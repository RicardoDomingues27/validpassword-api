package com.ricardo.domingues.validpassword.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.entities.Password;
import com.ricardo.domingues.validpassword.services.PasswordService;


@SpringBootTest
public class PasswordServiceTest {
	
    @Autowired
    PasswordService passwordService;
    
    @Test
    void whenReceivePasswordIsEmpty_ReturnFalse(){
    	Password password = new Password("");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(false, response);           
    }
    
    @Test
    void whenReceivePasswordWithMissingCharacter_ReturnFalse(){
    	Password password = new Password("aa");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(false, response);           
    }
    
    @Test
    void whenReceivePasswordWithMissingCharacterAndDuplicated_ReturnFalse(){
    	Password password = new Password("AAAbbbCc");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(false, response);           
    }
    
    @Test
    void whenReceivePasswordWithDuplicatedCharacter_ReturnFalse(){
    	Password password = new Password("AbTp9!foo");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(false, response);           
    }
    
    @Test
    void whenReceivePasswordWithBlankSpace_ReturnFalse(){
    	Password password = new Password("AbTp9 fok");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(false, response);           
    }
    
    @Test
    void whenReceivePasswordOk_ReturnTrue(){
    	Password password = new Password("AbTp9!fok");
		PasswordDTO dto = new PasswordDTO(password);	
		
        Boolean response = passwordService.validate(dto);

        assertEquals(true, response);
           
    }
}