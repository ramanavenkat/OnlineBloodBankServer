package com.springBoot.BloodBank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepo extends JpaRepository<projectModel, Integer>{

	projectModel findByEmail(String email);
	
//	@Query(value="select * from project_model p where p.blood_group=?1 and p.state=?2 and p.district=?3", nativeQuery = true)
//	List<findDonorModel> findByBloodGroupAndStateAndDistrict(String bloodGroup,String state,String district);
	
	List<projectModel> findByBloodGroup(String bloodGroup);



	
}
