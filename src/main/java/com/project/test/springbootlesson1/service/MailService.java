package com.project.test.springbootlesson1.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
@PropertySource("classpath:application.properties")
public class MailService {

    private Environment environment;

    private JavaMailSender javaMailSender;

    public void sendEmail(String email, MultipartFile file) {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper= null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mimeMessage.setFrom(environment.getProperty("spring.mail.username"));
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText("hello <a href=https://owu.com.ua>page</a>"   ,true);
            mimeMessageHelper.addAttachment(file.getOriginalFilename(),file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
