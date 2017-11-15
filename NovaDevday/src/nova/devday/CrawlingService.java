package nova.devday;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

	public static void main(String[] args) throws IOException {
		crawlData();
	}

	public static void crawlData() throws IOException {
		Connection.Response initial = Jsoup.connect(LOGIN_LINK).method(Connection.Method.GET).execute();

		Connection.Response login = Jsoup.connect(LOGIN_FORM).data(USERNAME_KEY, USERNAME_VALUE)
				.data(PASSWORD_KEY, PASSWORD_VALUE).cookies(initial.cookies()).method(Method.POST).execute();

		// For page 1
		crawlDataFromUrl(login, QUERY_STRING, 1);
		// For other pages
		Document pageContent = Jsoup.connect(QUERY_STRING).cookies(login.cookies()).get();
		Elements pagi = pageContent.select("div[class=pagination btn-group");
		Elements paginations = pagi.select("button[data-url]");
		Integer i = 1;
		for (Element pagination : paginations) {
			i++;
			crawlDataFromUrl(login, SERVER_HOST + pagination.attr("data-url"), i);
		}
	}

	private static void crawlDataFromUrl(Connection.Response login, String url, Integer pageNum) throws IOException {
		Document pageContent = Jsoup.connect(url).cookies(login.cookies()).get();
		Elements employeeLinks = pageContent.select("a[href]");
		int i = 0;
		for (Element employeeLink : employeeLinks) {
			if (employeeLink.attr("href").contains("resume/detail")) {
				i++;
				Ivy.log().info("Page: " + pageNum + ". No: " + i + "-------------------------" + SERVER_HOST
						+ employeeLink.attr("href") + "--------------------------");
				Document employeePage = Jsoup.connect(SERVER_HOST + employeeLink.attr("href")).cookies(login.cookies())
						.get();
				Elements leadContactResumtBtn = employeePage.select("button[id=leadContactResumtBtn");
				String leadContactResumtLink = leadContactResumtBtn.attr("abs:data-url");
				Ivy.log().info("Click link to buy: " + leadContactResumtLink);
				Elements infoTable = employeePage.select("table[class=table m-b-xs m-t");
				Iterator<Element> infoEachRow = infoTable.select("td").iterator();
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
				Ivy.log().info(printInformation(infoEachRow));
			}
		}
	}
	
	private static String printInformation(Iterator<Element> infoEachRow){
		String result = "";
		if (infoEachRow.hasNext()){
			result = infoEachRow.next().text();
		}
		if (infoEachRow.hasNext()){
			result += ": " + infoEachRow.next().text();
		}
		return result;
	}
}
