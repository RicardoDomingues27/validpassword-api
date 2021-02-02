package com.ricardo.domingues.validpassword.integration;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;

import io.cucumber.messages.internal.com.google.gson.Gson;

public class RestRT {

    private final PasswordDTO responseDTO;
    private final HttpStatus statusCode;
    private final Boolean result;

    RestRT(final ClientHttpResponse response, final HttpStatus statusCode) throws IOException {

        this.statusCode = statusCode;
        final InputStream bodyInputStream = response.getBody();
        final StringWriter stringWriter = new StringWriter();
        IOUtils.copy(bodyInputStream, stringWriter);
        System.out.println(stringWriter.toString());
        this.responseDTO = new Gson().fromJson(stringWriter.toString(), PasswordDTO.class);
        this.result = new Boolean(stringWriter.toString());
    }

    public PasswordDTO getResponseDTO() {
        return responseDTO;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
    
    public Boolean getResult() {
    	return result;
    }
}