package com.demo.bci.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class forestController {
	
	@GetMapping("/getForest")
	public ResponseEntity<String> findById() {
		return new ResponseEntity<>("Keto Keto BUM", HttpStatus.OK);
	}

}
