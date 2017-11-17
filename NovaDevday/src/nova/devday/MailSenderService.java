package nova.devday;


import java.util.List;

import nova.devday.persistent.CrawlingPersistentService;

import com.nova.devday.CandidateInfo;
import com.nova.devday.CrawlingEmail;

import ch.ivyteam.ivy.environment.Ivy;


public class MailSenderService {
	
	private String SENDER_MAIL = Ivy.var().get("com_nova_devday_sender_email");
	private String RECEIVER_MAIL = Ivy.var().get("com_nova_devday_receiver_email");
	private String EMAIL_SUBJECT = Ivy.cms().co("/nova/crawlingEmailSubject");
	private String EMAIL_CONTENT_TEMPLATE = Ivy.cms().co("/nova/emailContent");
	
	public CrawlingEmail buildEmailObject()
	{
		CrawlingEmail email = new CrawlingEmail();
		email.setSubject(EMAIL_SUBJECT);
		email.setFrom(SENDER_MAIL);
		email.setTo(RECEIVER_MAIL);
		email.setContent(buildMailContent());
		return email;
		
	}
	
	public String buildMailContent(){
		
		
		CrawlingPersistentService crawlingPersistentService = new CrawlingPersistentService();
		List<CandidateInfo> candidateInfos = crawlingPersistentService.getCandidateInfoList();
		StringBuilder mailContent = new StringBuilder();
       for (int i = 0; i < candidateInfos.size(); i++) {
		
			CandidateInfo candidateInfo = candidateInfos.get(i);
			mailContent.append("===============<br>");
			mailContent.append("Candicate " ).append(candidateInfo.getMostRecentJob()).append("<br>");
			//mailContent.append()
			
		}
       String emailCotent = EMAIL_CONTENT_TEMPLATE.replace("{content}", mailContent.toString());
		return emailCotent;
	}

}
