package com.ricardo.domingues.validpassword.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.services.PasswordService;


@RestController
@RequestMapping(value = "/password")
public class PasswordController {
	@Autowired 
	private PasswordService service;
	
	@PostMapping
	public ResponseEntity<Boolean> valid(@RequestBody @Valid PasswordDTO dto){			

		Boolean response = service.validate(dto);
		return response ? ResponseEntity.ok().body(response) : ResponseEntity.badRequest().body(response);		 
	}
	
}
