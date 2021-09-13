package utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

public class EmailSend{
	public static void sendEmail(String email,String subject,String message,String senderEmail,String senderEmailPassword){
		Properties properties = new Properties();
		
		properties.put("mail.transport.protocol","smtp");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.starttls.enable","true");

		Session mailSession = Session.getInstance(properties,new MyAuthenticator());

		MimeMessage mimeMessage = new MimeMessage(mailSession);
		
		try{
			mimeMessage.setFrom(senderEmail);
			mimeMessage.setRecipients(Message.RecipientType.TO,email);
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(message,"text/html");

			Transport.send(mimeMessage);
		}catch(MessagingException e){
			e.printStackTrace();
		}
	}
}
class MyAuthenticator extends Authenticator{
		public PasswordAuthentication getPasswordAuthentication(){

		return new PasswordAuthentication("legecyprezzie@gmail.com","Prezzie@1legecy");
	}
}