package nova.devday;

import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.model.value.SignalCode;

public class MailSenderService {
	
	private String SENDER_MAIL = Ivy.var().get("com_nova_devday_sender_email");
	private String RECEIVER_MAIL = Ivy.var().get("com_nova_devday_receiver_email");
	public static final String NOVA_PACKAGE = "ch:axonivy:fintech:soba";
	public static final String SIGNAL_CODE_SEDNING_EMAIL = NOVA_PACKAGE +":sendingEmail";

	
	public void sendMail()
	{
		String[] listSendEmail = RECEIVER_MAIL.trim().split(",");
		for(String email: listSendEmail)
		{
			Ivy.wf().signals().send(new SignalCode(SIGNAL_CODE_SEDNING_EMAIL), email);
		}
	}

}
