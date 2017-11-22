package com.commons.auth.web;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.commons.auth.model.User;

@Controller
public class SimpleEmailController {
    
    @Autowired
    private JavaMailSender sender;

    protected void sendEmail(User user, String subject, String testMsg) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setTo(user.getEmail());
        helper.setText(testMsg);
        helper.setSubject(subject);
        
        sender.send(message);
    }
}