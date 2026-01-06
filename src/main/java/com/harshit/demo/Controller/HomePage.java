package com.harshit.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomePage {
	
	@Autowired
	private JavaMailSender mailSender;

	
@GetMapping("/")
public  String home() {
	return "index";
}

@GetMapping("/contactForms")
public String contactform() {
    return "contactForm";  // This should match the HTML filename
}
@PostMapping("/contactInfo")
public String contactInfo(@RequestParam  String name, @RequestParam long phone, @RequestParam String  email, @RequestParam String message, @RequestParam String purpose) {
	SimpleMailMessage mail= new SimpleMailMessage();
	mail.setTo("harshit07code@gmail.com");
	mail.setSubject("Portfolio based message");
	mail.setText("name :" + name + "\n" + "Email :" +email + "\n" + "Phone number :"+ phone+"\n"+ "purpose:"+purpose +"\n" +"message" +message );
	mailSender.send(mail);
	return "thankspage";
}
	


}
