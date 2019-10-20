package com.example.tdhy.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.tdhy.service.MailService;

//邮件处理类
@Service
public class MailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JavaMailSenderImpl mailSender;

	@Value("${spring.mail.username}")
	private String from;

	@Override
	public void sendMimeMail(String to, String subject, String content) {
		// TODO Auto-generated method stub

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setSubject(subject);
			helper.setText(content, true);
			helper.setTo(to);
			helper.setFrom(from);

			mailSender.send(mimeMessage);
			// 日志信息
			logger.info("邮件已经发送");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("发送邮件时发送异常", e);
		}
	}

}
