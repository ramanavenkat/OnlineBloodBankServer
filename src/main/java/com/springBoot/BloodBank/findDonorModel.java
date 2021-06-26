package com.springBoot.BloodBank;

public class findDonorModel {
	
	private String bloodGroup;
	private String state;
	private String dist;
	
	
	public findDonorModel() {
		
	}


	public findDonorModel(String bloodGroup, String state, String dist) {
		super();
		this.bloodGroup = bloodGroup;
		this.state = state;
		this.dist = dist;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDist() {
		return dist;
	}


	public void setDist(String dist) {
		this.dist = dist;
	}


	@Override
	public String toString() {
		return "findDonorModel [bloodGroup=" + bloodGroup + ", state=" + state + ", dist=" + dist + "]";
	}


	

}
