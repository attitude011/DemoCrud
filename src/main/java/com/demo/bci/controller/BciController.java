package com.demo.bci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bci.entity.EntityUpdate;
import com.demo.bci.entity.EntityUser;
import com.demo.bci.entity.InsertEntity;
import com.demo.bci.services.CustomerServices;
import com.demo.bci.to.Convert;

@RestController
@RequestMapping("/api")

public class BciController {

	@Autowired
	CustomerServices callService;

	// Select By id
	@GetMapping("/get/{id}")
	public ResponseEntity<InsertEntity> findById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(callService.getRecordById(id), HttpStatus.OK);
	}

	// Insert new user in USER_TBL, with relation one-many with PHONES_TBL
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody EntityUser table) {
		return new ResponseEntity<>(callService.insertRecord(table), HttpStatus.OK);
	}
	
	// Update user record in USER_TBL
	@PutMapping("/update")
	public ResponseEntity<Convert> update(@RequestBody EntityUpdate records) {
		return new ResponseEntity<>(callService.updateRecord(records), HttpStatus.OK);
	}

}
