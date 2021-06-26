package com.springBoot.BloodBank;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String patientName;
	private String doctorName;
	private String bloodGroup;
	private String state;
	private String district;
	private String city;
	private String contactName;
	private String mobileNumber;
	private Date dateNeeded;
	private String priority;
	private String email;
	
	public RequestModel(int id, String patientName, String doctorName, String bloodGroup, String state, String district,
			String city, String contactName, String mobileNumber, Date dateNeeded, String priority, String email) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.bloodGroup = bloodGroup;
		this.state = state;
		this.district = district;
		this.city = city;
		this.contactName = contactName;
		this.mobileNumber = mobileNumber;
		this.dateNeeded = dateNeeded;
		this.priority = priority;
		this.email = email;
	}

	public RequestModel() {
		super();
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(Date dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
