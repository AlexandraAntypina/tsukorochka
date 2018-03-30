package com.alex.spring.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendSimpleEmail(String emailAdress, String subject, String message) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			mimeMessage.setContent(message, "text/plain; charset=utf-8");
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8"); 
			helper.setTo(emailAdress);
			helper.setSubject(subject);
			
			mailSender.send(mimeMessage);
		} catch(MailException | MessagingException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean sendHtmlEmail(String emailAdress, String subject, String message) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			mimeMessage.setContent(message, "text/html; charset=utf-8");
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8"); 
			helper.setTo(emailAdress);
			helper.setSubject(subject);
			
			mailSender.send(mimeMessage);
		} catch(MailException | MessagingException e) {
			return false;
		}
		
		return true;
	}
}
