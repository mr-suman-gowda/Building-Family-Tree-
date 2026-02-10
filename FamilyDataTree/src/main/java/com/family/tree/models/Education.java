package com.family.tree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Education")
public class Education {

    @Id
    private String level; // e.g., Primary, Secondary, Graduate, etc.
    private String institutionName;
    private String institutionAddress;
    private Integer graduated;

    public Education() {}

    // Getters and Setters
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public Integer getGraduated() {
        return graduated;
    }

    public void setGraduated(Integer graduated) {
        this.graduated = graduated;
    }

}
