package com.harshit.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.demo.Service.EmailService;


@Controller
public class HomePage {


	
@GetMapping("/")
public  String home() {
	return "index";
}

@GetMapping("/contactForms")
public String contactform() {
    return "contactForm";  // This should match the HTML filename
}


public HomePage(EmailService emailService) {
    this.emailService = emailService;
}

@Autowired
private EmailService emailService;



@PostMapping("/contactInfo")
public String contactInfo(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String phone,
        @RequestParam String purpose,
        @RequestParam String message) {

    emailService.sendEmail(name, email, phone, purpose, message);
    return "thankspage";
}
}

