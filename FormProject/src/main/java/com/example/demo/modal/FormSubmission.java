package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "placement_form_submissions")
public class FormSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String university;
    private String branch;
    private String degree;
    private String graduationYear;
    private String cgpa; // or Double cgpa if you want a numeric type
    private String programmingLanguages;
    private String toolsTechnologies;
    private String preferredJobRole;
    private String preferredLocation;

    public FormSubmission() {}

    public FormSubmission(String name, String email, String phone, String university,
                                   String branch, String degree, String graduationYear,
                                   String cgpa, String programmingLanguages, 
                                   String toolsTechnologies, String preferredJobRole, 
                                   String preferredLocation) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.university = university;
        this.branch = branch;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.cgpa = cgpa;
        this.programmingLanguages = programmingLanguages;
        this.toolsTechnologies = toolsTechnologies;
        this.preferredJobRole = preferredJobRole;
        this.preferredLocation = preferredLocation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String getToolsTechnologies() {
        return toolsTechnologies;
    }

    public void setToolsTechnologies(String toolsTechnologies) {
        this.toolsTechnologies = toolsTechnologies;
    }

    public String getPreferredJobRole() {
        return preferredJobRole;
    }

    public void setPreferredJobRole(String preferredJobRole) {
        this.preferredJobRole = preferredJobRole;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }
}
