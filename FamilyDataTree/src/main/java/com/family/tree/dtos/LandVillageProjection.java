package com.family.tree.dtos;

public class LandVillageProjection {
    private String surveyNumber;
    private String village;
    private Number acres;         // Changed from Integer to Double
    private Number gunta;         // Changed from Integer to Double
    private String waterSource;
    private Double totalArea;
    private Double totalLandArea;

    public LandVillageProjection() {}

    public String getSurveyNumber() {
        return surveyNumber;
    }

    public String getVillage() {
        return village;
    }

    public Number getAcres() {
        return acres;
    }

    public Number getGunta() {
        return gunta;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public Double getTotalArea() {
        return totalArea;
    }

	public Double getTotalLandArea() {
		return totalLandArea;
	}
}
