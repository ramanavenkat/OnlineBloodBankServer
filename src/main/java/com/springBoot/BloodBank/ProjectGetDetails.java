package com.springBoot.BloodBank;

import java.util.Arrays;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ProjectGetDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fullname;
	private String username;
	private String password;
	private String bloodGroup;
	private String gender;
	private Date dob;
	private String mobileNumber;
	private String state;
	private String district;
	private String city;
	private String pincode;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	public ProjectGetDetails(projectModel model) {
		this.fullname=model.getFullName();
		this.username=model.getEmail();
		this.password=model.getPassword();
		this.bloodGroup=model.getBloodGroup();
		this.gender=model.getGender();
		this.dob=model.getDob();
		this.mobileNumber=model.getMobileNumber();
		this.state=model.getState();
		this.district=model.getDistrict();
		this.city=model.getCity();
		this.pincode=model.getPinCode();
		this.active=model.isActive();
		this.authorities=Arrays.stream(model.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
