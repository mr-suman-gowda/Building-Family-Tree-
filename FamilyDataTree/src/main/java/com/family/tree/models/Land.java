package com.family.tree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("LandPlot")
public class Land {

    @Id
    private String surveyNumber; // Unique ID

    private String village;
    private Double acres;
    private Double gunta;
    private String waterSource;
    private String name; // display purpose

    public Land() {}

    // Getters and Setters
    public String getSurveyNumber() {
        return surveyNumber;
    }

    public void setSurveyNumber(String surveyNumber) {
        this.surveyNumber = surveyNumber;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Double getAcres() {
        return acres;
    }

    public void setAcres(double acres) {
        this.acres = acres;
    }

    public Double getGunta() {
        return gunta;
    }

    public void setGunta(double gunta) {
        this.gunta = gunta;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
