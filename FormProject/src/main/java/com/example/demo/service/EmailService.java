package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.modal.FormSubmission;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    // New method to build HTML email content
    public String buildEmailContent(FormSubmission placementFormSubmission) {
        return "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; }" +
                ".container { width: 100%; max-width: 600px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }" +
                ".header { background-color: #007bff; color: white; padding: 10px; text-align: center; border-radius: 5px 5px 0 0; }" +
                ".footer { margin-top: 20px; font-size: 12px; color: #777; text-align: center; }" +
                ".form-group { margin-bottom: 15px; }" +
                ".form-group label { font-weight: bold; }" +
                ".form-group div { background-color: #f8f9fa; padding: 10px; border: 1px solid #ccc; border-radius: 4px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='header'><h2>Placement Form Submission Confirmation</h2></div>" +
                "<h4>Dear " + placementFormSubmission.getName() + ",</h4>" +
                "<p>Thank you for your submission. Here are the details you provided:</p>" +
                "<div class='form-group'><label>Full Name:</label><div>" + placementFormSubmission.getName() + "</div></div>" +
                "<div class='form-group'><label>Email:</label><div>" + placementFormSubmission.getEmail() + "</div></div>" +
                "<div class='form-group'><label>Contact Number:</label><div>" + placementFormSubmission.getPhone() + "</div></div>" +
                "<div class='form-group'><label>University:</label><div>" + placementFormSubmission.getUniversity() + "</div></div>" +
                "<div class='form-group'><label>Branch:</label><div>" + placementFormSubmission.getBranch() + "</div></div>" +
                "<div class='form-group'><label>Degree:</label><div>" + placementFormSubmission.getDegree() + "</div></div>" +
                "<div class='form-group'><label>Graduation Year:</label><div>" + placementFormSubmission.getGraduationYear() + "</div></div>" +
                "<div class='form-group'><label>CGPA/Percentage:</label><div>" + placementFormSubmission.getCgpa() + "</div></div>" +
                "<div class='form-group'><label>Preferred Job Role:</label><div>" + placementFormSubmission.getPreferredJobRole() + "</div></div>" +
                "<div class='form-group'><label>Preferred Job Location:</label><div>" + placementFormSubmission.getPreferredLocation() + "</div></div>" +
                "<div class='footer'>We will get back to you shortly regarding the placement process.</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

    // New method to send HTML email
    public void sendHtmlMessage(String to, String subject, String htmlContent) {
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // Set to true to send HTML email
            emailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
