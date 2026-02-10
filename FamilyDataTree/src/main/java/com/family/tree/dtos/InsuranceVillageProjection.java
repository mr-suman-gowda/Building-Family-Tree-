package com.family.tree.dtos;

public class InsuranceVillageProjection {

    private String villageName;
    private long totalPersons;
    private long insuredPersons;
    private double totalInsuranceAmount;

    public InsuranceVillageProjection() {}

    public String getVillageName() {
        return villageName;
    }

    public long getTotalPersons() {
        return totalPersons;
    }

    public long getInsuredPersons() {
        return insuredPersons;
    }

    public double getTotalInsuranceAmount() {
        return totalInsuranceAmount;
    }
}
