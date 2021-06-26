package com.springBoot.BloodBank;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationResponse {

	private String jwt;
	
	private projectModel userDetails;
	
	private String privatemsg;
	
	public AuthenticationResponse() {
	
		
	}

	
	public AuthenticationResponse(String jwt, projectModel userDetails,String privatemsg) {
		super();
		this.jwt = jwt;
		this.userDetails = userDetails;
		this.privatemsg=privatemsg;
	}


	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public projectModel getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(projectModel userDetails) {
		this.userDetails = userDetails;
	}


	public String getPrivatemsg() {
		return privatemsg;
	}


	public void setPrivatemsg(String privatemsg) {
		this.privatemsg = privatemsg;
	}

	
	
	
	
	
	
}
