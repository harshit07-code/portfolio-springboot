package com.harshit.demo.Service;




import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendContactEmail(String name, String email, long phone, String purpose, String message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("harshit07code@gmail.com"); // Your email
            mail.setSubject("Portfolio based message");
            mail.setText("Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Phone number: " + phone + "\n"
                    + "Purpose: " + purpose + "\n"
                    + "Message: " + message);
            mailSender.send(mail);
        } catch (Exception e) {
            System.err.println("Email sending failed: " + e.getMessage());
        }
    }
}
