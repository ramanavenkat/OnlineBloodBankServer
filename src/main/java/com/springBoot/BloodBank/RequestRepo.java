package com.springBoot.BloodBank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<RequestModel, String> {

}
