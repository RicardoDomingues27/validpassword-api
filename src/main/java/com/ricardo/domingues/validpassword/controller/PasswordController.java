package com.ricardo.domingues.validpassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.services.PasswordSevice;


@RestController
@RequestMapping(value = "/password")
public class PasswordController {
	@Autowired 
	private PasswordSevice service;
	
	@PostMapping
	public ResponseEntity<Boolean> valid(@RequestBody PasswordDTO dto){
		
		
		Boolean response = service.valid(dto);
		
		return ResponseEntity.ok().body(response);
	}
	

}
