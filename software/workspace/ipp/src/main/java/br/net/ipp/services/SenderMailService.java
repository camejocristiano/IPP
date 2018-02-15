package br.net.ipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar() {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("camejocristiano@outlook.com");
        email.setSubject("subject");
        email.setText("text");
        mailSender.send(email);
    }
}