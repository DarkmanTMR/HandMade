//package com.example.handmade.services;
//
//import com.example.handmade.models.Client;
//import lombok.AllArgsConstructor;
//
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//
//@Service
//@AllArgsConstructor
//@PropertySource("classpath:application.properties")
//public class MailService {
//    private JavaMailSender javaMailSender;
//    private Environment env;
//
//
//    public void sendMessage(Client client) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//        try {
//            mimeMessage.setFrom(new InternetAddress((env.getRequiredProperty("spring.mail.username"))));
//            helper.setTo(client.getEmail());
//            helper.setText("<h1>Hello "+ client.getName() +"</h1> <div> your login is-"+client.getName()+ " </div>" , true);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        javaMailSender.send(mimeMessage);
//    }
//
//
//
//}
