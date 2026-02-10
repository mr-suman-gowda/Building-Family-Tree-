package com.family.tree.dtos;

public class VehicleVillageProjection {

    private String villageName;
    private Long car;
    private Long bike;
    private Long tractor;
    private Long bus;
    private Long truck;
    private Long others;
    private Integer totalVehichles;
    // Getters only
    public String getVillageName() {
        return villageName;
    }

    public Long getCar() {
        return car;
    }

    public Long getBike() {
        return bike;
    }

    public Long getTractor() {
        return tractor;
    }

    public Long getBus() {
        return bus;
    }

    public Long getTruck() {
        return truck;
    }

    public Long getOthers() {
        return others;
    }
    
    public Integer getTotalVehichles() {
    	return totalVehichles;
    }
}
