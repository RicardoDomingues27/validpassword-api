package com.ricardo.domingues.validpassword.dto;

import java.io.Serializable;

import com.ricardo.domingues.validpassword.entities.Password;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordDTO implements Serializable {

	private static final long serialVersionUID = 2386881934264932754L;
	
	private String text;
	
	public PasswordDTO(Password password) {
		text = password.getText();
	}

}
