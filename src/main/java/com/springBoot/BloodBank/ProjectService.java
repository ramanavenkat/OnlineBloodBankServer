package com.springBoot.BloodBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements UserDetailsService{
	
	@Autowired
	ProjectRepo repo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RequestRepo repos;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		projectModel model=repo.findByEmail(email);
		if(model==null) {
			throw new UsernameNotFoundException("Not Found...");
		}
		return new ProjectGetDetails(model);
	}

	public projectModel Save(projectModel Model) {
		System.out.println(Model.getDob());
		Model.setPassword(passwordEncoder.encode(Model.getPassword()));
	    projectModel model= repo.save(Model);	
	    return model;
	}
	
	public List<projectModel> find(findDonorModel model){
		System.out.println(model.toString());
		String bloodGroup=model.getBloodGroup();
		String state=model.getState();
		String district=model.getDist();
		List<projectModel> l=repo.findByBloodGroup(bloodGroup);
		System.out.println(l);
		return l;
	}

	public projectModel findByEmail(String email) {
		projectModel model=repo.findByEmail(email);
		return model;
	}
	public int count(String group) {
		List<projectModel> ctn=repo.findByBloodGroup(group);
		return ctn.size();
	}	
	public int reques(RequestModel model) {
		RequestModel l=repos.save(model);
		System.out.println(l);
		return 1;
		
	}
	
	public List<RequestModel> get() {
		List<RequestModel> model=repos.findAll();
		return model;
	}
	public int length() {
		List<RequestModel> l=repos.findAll();
		return l.size();
	}
	public List<projectModel> getUsers() {
		List<projectModel> model=repo.findAll();
		return model;
	}
	public int getCount() {
		List<projectModel> l=repo.findAll();
		return l.size();
	}
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted Successfully";
	}
}
