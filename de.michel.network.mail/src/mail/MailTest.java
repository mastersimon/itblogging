package mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class MailTest
{
	public static void main(String[] args) throws AddressException, MessagingException
	{
		String recipient = "info@itblogging.de";
		String subject = "Hallo zusammen ...";
		String text = "... ich bin eine E-Mail :-)";

		Mail.send(MailAccounts.GMX, recipient, subject, text);		
	}
}