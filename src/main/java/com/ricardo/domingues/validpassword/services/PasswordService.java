package com.ricardo.domingues.validpassword.services;

import org.springframework.stereotype.Service;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.entities.Password;

@Service
public class PasswordService {

	public Boolean validate(PasswordDTO dto) {
		final Password password = new Password(dto);
		return  password.isValid();
	}
}	
