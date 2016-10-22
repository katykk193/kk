package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by kk on 22/10/2016.
 */

@Component
public class SmtpMailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String to, String subject, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper Helper;

        // use the true flag to indicate you need a multipart message
        Helper = new MimeMessageHelper(message, true);

        Helper.setSubject(subject);
        Helper.setTo(to);
        Helper.setText(body,true);

        javaMailSender.send(message);
    }

}
