package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.deploy.Entity.Deploy;


public interface Deployeeemp extends JpaRepository<Deploy, Long>{
	
	 

}
