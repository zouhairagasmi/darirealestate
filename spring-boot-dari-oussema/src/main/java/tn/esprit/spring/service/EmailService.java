package tn.esprit.spring.service;

import java.io.File;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
    private JavaMailSender mailSender;
	
	public void sendMail(String to, String subject, String body) 
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        
    }
	
	public void sendMailWithAttachmen(String to, String subject, String body, String fileToAttach){
		
		MimeMessagePreparator preparator = new MimeMessagePreparator(){
			
			public void prepare(MimeMessage mimeMessage) throws Exception{
				
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress("consomitunis@gmail.com"));
				mimeMessage.setSubject(subject);
				//mimeMessage.setText(body);
				
				FileSystemResource file = new FileSystemResource(new File(fileToAttach));
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.addAttachment(file.getFilename(), file ) ;
				helper.setText(body, true);
			}
		};
		
		try{
			mailSender.send(preparator);
		}
		catch(MailException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	/*public void sendMailWithAttachmen(String to, String subject, String body, String fileToAttach){
		
		MimeMessage message = mailSender.createMimeMessage();
		try {
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    helper.setFrom("Consomi Tunis");
		    helper.setTo(to);
		    helper.setSubject(subject);
		    FileSystemResource file = new FileSystemResource(fileToAttach);
		    helper.addAttachment(file.getFilename(), file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		mailSender.send(message);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
