package com.springBoot.BloodBank;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class projectCont {

	@Autowired
	ProjectService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	ProjectService userDetailsService;
	@Autowired
	jwtUtil jwtTokenUtil;
	
	@GetMapping("/")
	public ResponseEntity<AuthenticationResponse> Home() {
		return ResponseEntity.ok(new AuthenticationResponse(null,null,"Logout Successfully"));
	}
	
	@PostMapping(value="/save",produces="application/json")
	public ResponseEntity<projectModel> save(@RequestBody projectModel Model) {
		projectModel model=service.Save(Model);	
		if(model==null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(model);
		}
	}
	@GetMapping("/welcom")
	public String homer() {
		return "Welcome to home page";
	}
	@PostMapping("/check")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		System.out.println("authenticated");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			return ResponseEntity.ok(new AuthenticationResponse(null,null,"Invalid Username or Password"));
//			throw new Exception("Incorrect Username or passowrd");
		}
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final projectModel model=userDetailsService.findByEmail(authenticationRequest.getEmail());
		final String jwt=jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,model,"Login Successfull"));
	}
	
	@PostMapping("/find")
	public List<projectModel> search(@RequestBody findDonorModel model){
		System.out.println(model.toString());
		List<projectModel> l=service.find(model);
		return l;
	}
	
	@GetMapping("/count")
	public List<Integer> count(){
		String[] l= {"A-","A+","B-","B+","AB-","AB+","O-","O+"};
		List<Integer> c=new ArrayList<>();
		for(int i=0;i<8;i++) {
			c.add(service.count(l[i]));
		}
		return c;
	}
	
	@PostMapping("/request")
	public ResponseEntity<?> request(@RequestBody RequestModel model) {
		int i=service.reques(model);
		return ResponseEntity.ok(new AuthenticationResponse(null,null,"Patient Details Saved Successfully"));
	}
	
	@GetMapping("/getData")
	public List<RequestModel> getDetails() {
		List<RequestModel> model=service.get();
		return model;
	}
	@GetMapping("/scroll")
	public int length() {
		int i=service.length();
		return i;
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		return ResponseEntity.ok(new AuthenticationResponse(null,null,"Logout"));
	}
	@GetMapping("/aUser")
	public List<projectModel> getUser(){
		List<projectModel> model=service.getUsers();
		return model;
	}
	@GetMapping("/getAdmin")
	public int getCount(){
		int l=service.getCount();
		return l;
	}
	@DeleteMapping("/deleted/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		System.out.println(id);
		String msg=service.delete(id);
		return ResponseEntity.ok(new AuthenticationResponse(null,null,msg));
	}
	
}
