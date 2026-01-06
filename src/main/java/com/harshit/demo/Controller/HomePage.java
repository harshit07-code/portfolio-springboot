package com.harshit.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.demo.Service.EmailService;


@Controller
public class HomePage {

	private final EmailService emailService;
	
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

@PostMapping("/contactInfo")
public String contactInfo(
        @RequestParam String name,
        @RequestParam long phone,
        @RequestParam String email,
        @RequestParam String message,
        @RequestParam String purpose) {

    // Send email in background
    emailService.sendContactEmail(name, email, phone, purpose, message);

    // Immediately return thank you page
    return "thankspage";
}
}
