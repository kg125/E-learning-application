package eduWebApp.service;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
	public JavaMailSender emailSender;


	@Override
	public void send(String fromAddress, String toAddress, String subject, String content) throws Exception {

		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
		
		messageHelper.setFrom(fromAddress);
		messageHelper.setTo(toAddress);
		messageHelper.setSubject(subject);
		messageHelper.setText(content, true);
		messageHelper.setSentDate(new Date());
		emailSender.send(mimeMessage);
		
	}
}


