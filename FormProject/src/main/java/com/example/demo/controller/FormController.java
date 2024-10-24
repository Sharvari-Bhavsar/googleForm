package com.example.demo.controller;



import com.example.demo.modal.FormSubmission;
import com.example.demo.repository.FormRepository;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formSubmission", new FormSubmission());
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute FormSubmission placementFormSubmission, Model model) {
        formRepository.save(placementFormSubmission);

        // Build email content
    
        String emailContent = emailService.buildEmailContent(placementFormSubmission);


        // Send confirmation email
        emailService.sendHtmlMessage(
            placementFormSubmission.getEmail(), 
            "Placement Form Submission Confirmation", 
            emailContent
        );

        model.addAttribute("message", "Form submitted successfully and confirmation email sent!");
        return "form"; // Return to the same form page or a success page
    }

	
}
