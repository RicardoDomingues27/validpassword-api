package com.ricardo.domingues.validpassword.entities;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.error.NotNullPasswordException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Password implements Serializable{

	private static final long serialVersionUID = 6391105446486034977L;
	
	private String text;
	
	public Password(PasswordDTO dto){
		text = dto.getText();
	}

	public Boolean isValid() {
		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()+-])(?!.*(.).*\\1).{9,}$");
		Matcher matcher; 
		
		try{
			matcher = pattern.matcher(this.text);
		}catch(NullPointerException e){
			throw new NotNullPasswordException("Not Null Password!");
		}
		return  matcher.find();
	}
}
