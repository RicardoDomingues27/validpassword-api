package com.ricardo.domingues.validpassword.controller;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.entities.Password;

import io.restassured.http.ContentType;

@SpringBootTest
public class PasswordControllerTest {

	@Autowired
	private PasswordController passwordController;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.passwordController);
	}
	@Test 
	public void  whenReceivePasswordOk_ReturnStatusOK() {
		final Password password = new Password("AbTp9!fok");
		final PasswordDTO dto = new PasswordDTO(password);
		
		given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(dto)
			.log().all()
		.when()
			.post("/password")
		.then()
			.statusCode(HttpStatus.OK.value());
		
	}	
	
	@Test
	public void whenReceivePasswordIsEmpty_ReturnBadRequest() {
		final Password password = new Password("");
		final PasswordDTO dto = new PasswordDTO(password);		
		
		given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(dto)
			.log().all()
		.when()
			.post("/password")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
	}
	
	@Test
	public void whenNotReceivePassword_ReturnBadRequest() {		
		
		given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.log().all()
		.when()
			.post("/password")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
	}
}
