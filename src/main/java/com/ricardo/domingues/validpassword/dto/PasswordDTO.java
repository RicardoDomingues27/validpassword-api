package com.ricardo.domingues.validpassword.dto;

import com.ricardo.domingues.validpassword.entities.Password;

public class PasswordDTO {

	private String text;
	
	public PasswordDTO() {
	}
	
	public PasswordDTO(Password password) {
		super();
		text = password.getText();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
