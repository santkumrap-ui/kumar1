package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.deploy.Entity.Deploy;
import com.practice.service.Deployservice;

@RestController
@RequestMapping("/deploy")
//@CrossOrigin("*")
public class Deploycontroller {

	@Autowired
	
	private Deployservice deployservice;
	
	@GetMapping("/all")
	public ResponseEntity<List<Deploy>> getAllDeploys(){
		
		List<Deploy> deploys= deployservice.getAlldeploy();
		return new ResponseEntity<>(deploys, HttpStatus.OK);
		
		
	}
	@PostMapping("/dd")
	public ResponseEntity<List<Deploy>> createDeploy(@RequestBody List<Deploy> deploy){
		List<Deploy> save = deployservice.createDeploy(deploy);
		return new ResponseEntity<>(save,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Deploy> getById(@PathVariable Long id){
	Deploy deploy = deployservice.getById(id);
	if(deploy!=null)
		return new ResponseEntity<>(deploy, HttpStatus.OK);
	else
	return null;	
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Deploy> updateDeploy(
	        @PathVariable Long id,
	        @RequestBody Deploy deploy) {

	    Deploy updated = deployservice.updatedeploy(id, deploy);

	    if (updated == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteDeploy(@PathVariable Long id){
		
		boolean  deleted = deployservice.deleteDeploy(id);
		if(!deleted)
		return null;
		else
			return new ResponseEntity<>("suveede",HttpStatus.OK);
		
		
		
	}
			
}
