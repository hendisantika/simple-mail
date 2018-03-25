package com.hendisantika.simplemail;

import com.hendisantika.simplemail.mail.EmailService;
import com.hendisantika.simplemail.mail.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleMailApplication implements ApplicationRunner {
    private static Logger log = LoggerFactory.getLogger(SimpleMailApplication.class);

    @Autowired
    private EmailService emailService;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("Spring Mail - Sending Simple Email with JavaMailSender Example");

        Mail mail = new Mail();
        mail.setFrom("no-reply@hendisantika.com");
        mail.setTo("info@hendisantika.com");
        mail.setSubject("Sending Simple Email with JavaMailSender Example");
        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

        emailService.sendSimpleMessage(mail);
    }

	public static void main(String[] args) {
		SpringApplication.run(SimpleMailApplication.class, args);
	}
}
