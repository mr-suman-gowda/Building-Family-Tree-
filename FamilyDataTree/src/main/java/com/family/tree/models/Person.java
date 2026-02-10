package com.family.tree.models;

import org.springframework.data.annotation.Id;

public class Person {

    @Id
    private String aadharId;

    private String name;
    private String gender;
    private String mobile;
    private String dob; // stored as String for simplicity
    private String education;
    private String employment;
    private String address;

    public Person() {}

    // Getters and Setters
    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getVillage() {
        return address;
    }

    public void setVillage(String address) {
        this.address = address;
    }
}
