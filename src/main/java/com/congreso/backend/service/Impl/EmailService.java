package com.congreso.backend.service.Impl;


import com.congreso.backend.service.EmailServiceS;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService implements EmailServiceS {
//    private final JavaMailSender mailSender;

//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    @Override
    public void sendPasswordResetToken(String email, String token) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("Recuperación de Contraseña");
//        message.setText("Use este código para recuperar su contraseña: " + token);
//        mailSender.send(message);
    }
}
