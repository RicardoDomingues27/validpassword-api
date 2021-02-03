package com.ricardo.domingues.validpassword.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.model.Password;
import com.ricardo.domingues.validpassword.services.PasswordService;


@SpringBootTest
class PasswordServiceTest {
	
    @Autowired
    PasswordService passwordService;
    @ParameterizedTest
    @ValueSource(strings = {"", "aa", "AAAbbbCc", "AbTp9!foo", "AbTp9 fok"})
    void whenReceivePasswordIsInvalid_ReturnFalse(String strings){
    	Password password = new Password(strings);
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(false, response);           
    }

    @Test
    void whenReceivePasswordIsValid_ReturnTrue(){
    	Password password = new Password("AbTp9!fok");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(true, response);
           
    }
}