package com.ricardo.domingues.validpassword.integration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;

import com.ricardo.domingues.validpassword.ValidPasswordApplication;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ValidPasswordApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {

    private static final Gson GSON = new Gson();

    @Autowired
    protected TestRestTemplate restTemplate;

    public RestRT latestResponse;

    public void executePost(String url, Object body) throws IOException {
        String json = GSON.toJson(body);
        final HeaderSRC requestCallback = new HeaderSRC(json);
        latestResponse = restTemplate.execute(url, HttpMethod.POST, requestCallback, response -> new RestRT(response, response.getStatusCode()));
    }

}