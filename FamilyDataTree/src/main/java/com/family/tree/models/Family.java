package com.family.tree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Family")
public class Family {
    
	@Id
    private String headID;
    private String headName;

    private int total_0_18;
    private int total_18_plus;
    
    public Family() {};
	public Family(String headID, String headName, int total_0_18, int total_18_plus) {
		super();
		this.headID = headID;
		this.headName = headName;
		this.total_0_18 = total_0_18;
		this.total_18_plus = total_18_plus;
	}

	public String getHeadID() {
		return headID;
	}
	public void setHeadID(String headID) {
		this.headID = headID;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public int getTotal_0_18() {
		return total_0_18;
	}
	public void setTotal_0_18(int total_0_18) {
		this.total_0_18 = total_0_18;
	}
	public int getTotal_18_plus() {
		return total_18_plus;
	}
	public void setTotal_18_plus(int total_18_plus) {
		this.total_18_plus = total_18_plus;
	}

    // Getters and Setters
}
