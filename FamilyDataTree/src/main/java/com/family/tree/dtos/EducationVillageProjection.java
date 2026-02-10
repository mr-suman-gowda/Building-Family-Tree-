package com.family.tree.dtos;

public class EducationVillageProjection {

	    private String villageName;
	    private Integer graduated;
	    private Integer studying;
	    private Integer illiterate;
	    private Integer educationFacility;


    public EducationVillageProjection() {}

    public String getVillageName() {
        return villageName;
    }

    public Integer getGraduated() {
        return graduated;
    }

    public Integer getStudying() {
        return studying;
    }

    public Integer getIlliterate() {
        return illiterate;
    }

    public Integer getEducationFacility() {
        return educationFacility;
    }
}
