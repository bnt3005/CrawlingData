package nova.devday;


import com.nova.devday.CrawlingEmail;

import ch.ivyteam.ivy.environment.Ivy;


public class MailSenderService {
	
	private String SENDER_MAIL = Ivy.var().get("com_nova_devday_sender_email");
	private String RECEIVER_MAIL = Ivy.var().get("com_nova_devday_receiver_email");
	private String EMAIL_SUBJECT = Ivy.cms().co("/nova/crawlingEmailSubject");
	private String EMAIL_CONTENT = Ivy.cms().co("/nova/emailContent");
	
	public CrawlingEmail buildEmailObject()
	{
		CrawlingEmail email = new CrawlingEmail();
		email.setSubject(EMAIL_SUBJECT);
		email.setFrom(SENDER_MAIL);
		email.setTo(RECEIVER_MAIL);
		email.setContent(EMAIL_CONTENT);
		return email;
		
	}

}
