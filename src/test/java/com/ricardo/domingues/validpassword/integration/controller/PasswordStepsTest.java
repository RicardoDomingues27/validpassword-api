package com.ricardo.domingues.validpassword.integration.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.entities.Password;
import com.ricardo.domingues.validpassword.integration.SpringIntegrationTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PasswordStepsTest extends SpringIntegrationTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    protected TestRestTemplate restTempla;
    
	@When("the client calls \\/v1\\/password with a {string} valid")
	public void the_client_calls_v1_password_with_a_valid(String text) throws IOException {
		Password password = new Password(text);
		PasswordDTO dto = new PasswordDTO(password);
        executePost("http://localhost:8080/v1/password", dto);
	}

	@Then("the client receives status code of {int}")
	public void the_client_receives_status_code_of(Integer expectedCode) {
		int receivedStatusCode = latestResponse.getStatusCode().value();
        assertThat("", receivedStatusCode, is(expectedCode));
	}
	@Then("the client receives the true")
	public void the_client_receives_the_true() {
		assertThat("", latestResponse.getResult() != null);
	}



}
