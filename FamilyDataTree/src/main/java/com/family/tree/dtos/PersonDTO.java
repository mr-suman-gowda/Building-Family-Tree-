package com.family.tree.dtos;

public class PersonDTO {

    private String name;
    private String aadharId;
    private String gender;
    private String mobile;
    private String dob;
    private String education;
    private String employment;
    private String address;
    private Integer totalPerson;
    private Double allTotalPerson;
    
    public PersonDTO() {}

    // Getters
    public String getName() {
        return name;
    }

    public String getAadharId() {
        return aadharId;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDob() {
        return dob;
    }

    public String getEducation() {
        return education;
    }

    public String getEmployment() {
        return employment;
    }

    public String getAddress() {
        return address;
    }
    
    public Integer getTotalPeron() {
    	return totalPerson;
    }
    
    public Double getAllTotalPerson() {
    	return allTotalPerson;
    }
}
