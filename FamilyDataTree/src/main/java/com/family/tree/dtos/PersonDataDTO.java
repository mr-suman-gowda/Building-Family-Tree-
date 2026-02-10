package com.family.tree.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDataDTO {
    private String aadhar;
    private String name;
    private String gender;
    private String maritalStatus;
    private String fatherName;
    private String pan;
    private String voterId;
    private String pollingStation;
    private String aplStatus;
    private String bplStatus;
    private String bloodGroup;
    private String mobile;
    private String dob;
    private String udid;
    private String healthIssues;
    private String houseStatus;
    private String permanentAddress;
    private String employmentStatus;
    private String selfemployed;
    private String businessType;

    private String educationLevel;
    private String institutionName;
    private String institutionAddress;
    private String graduated;

    private String vehicleType;
    private String registrationNo;
    private String vehicleInsuranceNo;
    private String vehicleInsuranceProvider;
    private String vehicleInsuranceExpiry;
    private String insurancePremium;

    private String hasHealthInsurance;
    private String healthInsurer;
    private String insuranceAmount;

    private String landHave;
    private String landServeyNo;
    private String landVillageName;
    private String acres;
    private String gunta;
    private String waterSource;

    private String cropHave;
    private String cropName;
    private String fishery;
    private String silkWorm;
    private String cropInsurance;

    private String fertilizers;
    private String tools;

    private String cows;
    private String goats;
    private String sheeps;
    private String hen;

    private String membershipType;
    private String loanAmount;
    private String loanFrequency;

    @JsonProperty("Ishead")
    private String Ishead;
    private String familyAbove18;
    private String familyBleow18;
    private String headAadharId;

    // Getters and setters for all fields (can be generated in IDE or written manually)
    public String getAadhar() { return aadhar; }
    public void setAadhar(String aadhar) { this.aadhar = aadhar; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getVoterId() { return voterId; }
    public void setVoterId(String voterId) { this.voterId = voterId; }

    public String getPollingStation() { return pollingStation; }
    public void setPollingStation(String pollingStation) { this.pollingStation = pollingStation; }

    public String getAplStatus() { return aplStatus; }
    public void setAplStatus(String aplStatus) { this.aplStatus = aplStatus; }

    public String getBplStatus() { return bplStatus; }
    public void setBplStatus(String bplStatus) { this.bplStatus = bplStatus; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getUdid() { return udid; }
    public void setUdid(String udid) { this.udid = udid; }

    public String getHealthIssues() { return healthIssues; }
    public void setHealthIssues(String healthIssues) { this.healthIssues = healthIssues; }

    public String getHouseStatus() { return houseStatus; }
    public void setHouseStatus(String houseStatus) { this.houseStatus = houseStatus; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public String getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; }

    public String getSelfemployed() { return selfemployed; }
    public void setSelfemployed(String selfemployed) { this.selfemployed = selfemployed; }

    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }

    public String getEducationLevel() { return educationLevel; }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }

    public String getInstitutionName() { return institutionName; }
    public void setInstitutionName(String institutionName) { this.institutionName = institutionName; }

    public String getInstitutionAddress() { return institutionAddress; }
    public void setInstitutionAddress(String institutionAddress) { this.institutionAddress = institutionAddress; }

    public String getGraduated() { return graduated; }
    public void setGraduated(String graduated) { this.graduated = graduated; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getRegistrationNo() { return registrationNo; }
    public void setRegistrationNo(String registrationNo) { this.registrationNo = registrationNo; }

    public String getVehicleInsuranceNo() { return vehicleInsuranceNo; }
    public void setVehicleInsuranceNo(String vehicleInsuranceNo) { this.vehicleInsuranceNo = vehicleInsuranceNo; }

    public String getVehicleInsuranceProvider() { return vehicleInsuranceProvider; }
    public void setVehicleInsuranceProvider(String vehicleInsuranceProvider) { this.vehicleInsuranceProvider = vehicleInsuranceProvider; }

    public String getVehicleInsuranceExpiry() { return vehicleInsuranceExpiry; }
    public void setVehicleInsuranceExpiry(String vehicleInsuranceExpiry) { this.vehicleInsuranceExpiry = vehicleInsuranceExpiry; }

    public String getInsurancePremium() { return insurancePremium; }
    public void setInsurancePremium(String insurancePremium) { this.insurancePremium = insurancePremium; }

    public String getHasHealthInsurance() { return hasHealthInsurance; }
    public void setHasHealthInsurance(String hasHealthInsurance) { this.hasHealthInsurance = hasHealthInsurance; }

    public String getHealthInsurer() { return healthInsurer; }
    public void setHealthInsurer(String healthInsurer) { this.healthInsurer = healthInsurer; }

    public String getInsuranceAmount() { return insuranceAmount; }
    public void setInsuranceAmount(String insuranceAmount) { this.insuranceAmount = insuranceAmount; }

    public String getLandHave() { return landHave; }
    public void setLandHave(String landHave) { this.landHave = landHave; }

    public String getLandServeyNo() { return landServeyNo; }
    public void setLandServeyNo(String landServeyNo) { this.landServeyNo = landServeyNo; }

    public String getLandVillageName() { return landVillageName; }
    public void setLandVillageName(String landVillageName) { this.landVillageName = landVillageName; }

    public String getAcres() { return acres; }
    public void setAcres(String acres) { this.acres = acres; }

    public String getGunta() { return gunta; }
    public void setGunta(String gunta) { this.gunta = gunta; }

    public String getWaterSource() { return waterSource; }
    public void setWaterSource(String waterSource) { this.waterSource = waterSource; }

    public String getCropHave() { return cropHave; }
    public void setCropHave(String cropHave) { this.cropHave = cropHave; }

    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }

    public String getFishery() { return fishery; }
    public void setFishery(String fishery) { this.fishery = fishery; }

    public String getSilkWorm() { return silkWorm; }
    public void setSilkWorm(String silkWorm) { this.silkWorm = silkWorm; }

    public String getCropInsurance() { return cropInsurance; }
    public void setCropInsurance(String cropInsurance) { this.cropInsurance = cropInsurance; }

    public String getFertilizers() { return fertilizers; }
    public void setFertilizers(String fertilizers) { this.fertilizers = fertilizers; }

    public String getTools() { return tools; }
    public void setTools(String tools) { this.tools = tools; }

    public String getCows() { return cows; }
    public void setCows(String cows) { this.cows = cows; }

    public String getGoats() { return goats; }
    public void setGoats(String goats) { this.goats = goats; }

    public String getSheeps() { return sheeps; }
    public void setSheeps(String sheeps) { this.sheeps = sheeps; }

    public String getHen() { return hen; }
    public void setHen(String hen) { this.hen = hen; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public String getLoanAmount() { return loanAmount; }
    public void setLoanAmount(String loanAmount) { this.loanAmount = loanAmount; }

    public String getLoanFrequency() { return loanFrequency; }
    public void setLoanFrequency(String loanFrequency) { this.loanFrequency = loanFrequency; }

    public String getIshead() { return Ishead; }
    public void setIshead(String ishead) { this.Ishead = ishead; }

    public String getFamilyAbove18() { return familyAbove18; }
    public void setFamilyAbove18(String familyAbove18) { this.familyAbove18 = familyAbove18; }

    public String getFamilyBleow18() { return familyBleow18; }
    public void setFamilyBleow18(String familyBleow18) { this.familyBleow18 = familyBleow18; }
	
    public String getHeadAadharId() {
		return headAadharId;
	}
	public void setHeadAadharId(String headAadharId) {
		this.headAadharId = headAadharId;
	}
    
    
}

