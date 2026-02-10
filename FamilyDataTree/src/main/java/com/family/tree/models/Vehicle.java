package com.family.tree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Vehicle")
public class Vehicle {

    @Id
    private String registrationNumber;

    private String type;
    private String name; // duplicated from type for UI display
    private String insuNo;
    private String provider;
    private String expdate;
    private String premium;

    public Vehicle() {}

    public Vehicle(String registrationNumber, String type, String name, String insuNo, String provider, String expdate, String premium) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.name = name;
        this.insuNo = insuNo;
        this.provider = provider;
        this.expdate = expdate;
        this.premium = premium;
    }

    // Getters and Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuNo() {
        return insuNo;
    }

    public void setInsuNo(String insuNo) {
        this.insuNo = insuNo;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }
}
