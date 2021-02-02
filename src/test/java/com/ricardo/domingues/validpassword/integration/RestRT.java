package com.ricardo.domingues.validpassword.integration;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

public class RestRT {
    
    private final HttpStatus statusCode;
    private final Boolean response;

    @SuppressWarnings("deprecation")
	RestRT(final ClientHttpResponse response, final HttpStatus statusCode) throws IOException {

        this.statusCode = statusCode;
        final InputStream bodyInputStream = response.getBody();
        final StringWriter stringWriter = new StringWriter();
        IOUtils.copy(bodyInputStream, stringWriter);
        this.response = Boolean.parseBoolean(stringWriter.toString());       
        
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
    
    public Boolean getResponse() {
    	return response;
    }
}