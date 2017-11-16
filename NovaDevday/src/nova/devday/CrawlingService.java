package nova.devday;

import java.io.IOException;

import nova.devday.persistent.CrawlingPersistentService;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nova.devday.CandidateInfo;

import ch.ivyteam.ivy.environment.Ivy;

public class CrawlingService {
	private static final String SERVER_HOST = "https://employer.vietnamworks.com";
	private static final String PASSWORD_VALUE = "Novatofintech";
	private static final String PASSWORD_KEY = "_password";
	private static final String USERNAME_VALUE = "hcmcnova@gmail.com";
	private static final String USERNAME_KEY = "_username";
	private static final String LOGIN_FORM = SERVER_HOST + "/v2/login_check";
	private static final String LOGIN_LINK = SERVER_HOST + "/v2/login";
	private static final String QUERY_STRING = SERVER_HOST + "/v2/resume/search?searchResume%5Bkeyword%5D=java&searchResume%5BjobLevelId%5D=&searchResume%5BlastModified%5D=3&btnResumeSearch=1&searchResume%5ByearExperience%5D=&searchResume%5Bnationality%5D=&searchResume%5Blanguage%5D=&searchResume%5BlanguageLevel%5D=&searchResume%5BageFrom%5D=&searchResume%5BageTo%5D=&searchResume%5BsalaryFrom%5D=&searchResume%5BsalaryTo%5D=&searchResume%5BgenderId%5D=";
	static CrawlingPersistentService crawlingPersistentService = new CrawlingPersistentService();
	
	public static void crawlData() throws IOException {
		Connection.Response initial = Jsoup.connect(LOGIN_LINK).method(Connection.Method.GET).execute();

		Connection.Response login = Jsoup.connect(LOGIN_FORM).data(USERNAME_KEY, USERNAME_VALUE)
				.data(PASSWORD_KEY, PASSWORD_VALUE).cookies(initial.cookies()).method(Method.POST).execute();

		// For page 1
		crawlDataFromUrl(login, QUERY_STRING, 1);
		// For other pages
		Document pageContent = Jsoup.connect(QUERY_STRING).cookies(login.cookies()).get();
		Elements paginationPanel = pageContent.select("div[class=pagination btn-group");
		Elements paginations = paginationPanel.select("button[data-url]");
		Integer pageNo = 1;
		for (Element pagination : paginations) {
			pageNo++;
			crawlDataFromUrl(login, SERVER_HOST + pagination.attr("data-url"), pageNo);
		}
	}

	private static void crawlDataFromUrl(Connection.Response login, String url, Integer pageNo) throws IOException {
		Document pageContent = Jsoup.connect(url).cookies(login.cookies()).get();
		Elements employeeLinks = pageContent.select("a[href]");
		int candidateNo = 0;
		for (Element employeeLink : employeeLinks) {
			if (employeeLink.attr("href").contains("resume/detail")) {
				employeeLink.attr("href").substring(employeeLink.attr("href").length() - employeeLink.attr("href").indexOf("/"));
				String candidateId = employeeLink.attr("href").replace("/v2/resume/detail/", "");
				candidateNo++;
				CandidateInfo candidateInfo = new CandidateInfo();
				candidateInfo.setCandidateId(candidateId);
				candidateInfo.setProfileLink(SERVER_HOST + employeeLink.attr("href"));
				candidateInfo.setPageNo(pageNo);
				candidateInfo.setCandidateNo(candidateNo);
				Document employeePage = Jsoup.connect(SERVER_HOST + employeeLink.attr("href")).cookies(login.cookies()).get();
				Elements leadContactResumtBtn = employeePage.select("button[id=leadContactResumtBtn");
				String leadContactResumtLink = leadContactResumtBtn.attr("abs:data-url");
				candidateInfo.setContactLink(leadContactResumtLink);
				Elements infoTable = employeePage.select("table[class=table m-b-xs m-t");
				Elements infoRows = infoTable.select("td");
				int infoNo = 1;
				for (Element infoRow : infoRows) {
					if(infoNo % 2 == 0 && infoRow.hasText()){
						initCandidateInfo(infoNo, candidateInfo, infoRow.text());
					}
					infoNo++;
				}
				Ivy.log().info(candidateInfo);
				crawlingPersistentService.addCandidate(candidateInfo);
			}
		}
	}
	
	private static void initCandidateInfo(Integer i, CandidateInfo candidateInfo, String info){
		switch(i){
		case 2: 
			candidateInfo.setHighestEducation(info);
			break;
		case 4: 
			candidateInfo.setYearsOfExperience(info);
			break;
		case 6: 
			candidateInfo.setLanguages(info);
			break;
		case 8: 
			candidateInfo.setMostRecentJob(info);
			break;
		case 10: 
			candidateInfo.setLatestCompany(info);
			break;
		case 12: 
			candidateInfo.setExperienceLevel(info);
			break;
		case 14: 
			candidateInfo.setExpectedPosition(info);
			break;
		case 16: 
			candidateInfo.setExpectedJobLevel(info);
			break;
		case 18: 
			candidateInfo.setJobLocations(info);
			break;
		case 20: 
			candidateInfo.setJobIndustriesFunctions(info);
			break;
		case 22: 
			candidateInfo.setMinimumExpectedSalary(info);
			break;
		}
	}
	
}
