package com.ricardo.domingues.validpassword.integration.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.io.IOException;

import com.ricardo.domingues.validpassword.error.NotNullPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.entities.Password;
import com.ricardo.domingues.validpassword.integration.SpringIntegration;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordSteps extends SpringIntegration {


    @Autowired
    protected TestRestTemplate restTempla;
    
	@When("the client calls \\/v1\\/password with a {string} valid")
	public void the_client_calls_v1_password_with_a_valid(String text) throws IOException {
		final Password password = new Password(text);
		final PasswordDTO dto = new PasswordDTO(password);
        executePost("http://localhost:8080/v1/password", dto);
	}

	@Then("the client receives status code of {int}")
	public void the_client_receives_status_code_of(Integer expectedCode) {
		final int receivedStatusCode = latestResponse.getStatusCode().value();
        assertThat(receivedStatusCode, is(expectedCode));
	}
	@Then("the client receives the true")
	public void the_client_receives_the_true() {
		assertThat(latestResponse.getResponse(), is(true));
	}


	@When("the client calls \\/v1\\/password with a {string} invalid")
	public void the_client_calls_v1_password_with_a_invalid(String text) throws IOException {
		final Password password = new Password(text);
		final PasswordDTO dto = new PasswordDTO(password);
		executePost("http://localhost:8080/v1/password", dto);
	}

	@Then("the client receives the false")
	public void the_client_receives_the_false() {
		assertThat(latestResponse.getResponse(), is(false));
	}

	@When("the client calls \\/v1\\/password with a {string}")
	public void the_client_calls_v1_password_with_a(String string) throws IOException {
		final Password password = new Password("a");
		final PasswordDTO dto = new PasswordDTO(password);
		executePost("http://localhost:8080/v1/password", dto);
	}

	@Then("I should see a validation error")
	public void i_should_see_a_validation_error() {
		Throwable exception = assertThrows(NotNullPasswordException.class, () -> {
			throw new NotNullPasswordException("Not Null Password!");
		});
		assertEquals("Not Null Password!", exception.getMessage());
	}

}
