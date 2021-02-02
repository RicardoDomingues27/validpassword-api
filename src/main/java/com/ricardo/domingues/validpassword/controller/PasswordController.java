package com.ricardo.domingues.validpassword.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;
import com.ricardo.domingues.validpassword.services.PasswordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping(value = "/v1")
@Tag(name = "Controller" , description = "Endpoint to receive password text")

public class PasswordController {
	
	@Autowired 
	private PasswordService service;
		
	@Operation(summary = "Return password validate")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "validated text",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PasswordDTO.class))) }),
            @ApiResponse(responseCode = "400", description = "text does not follow the requested requirements", content = @Content)
            })
	
	@PostMapping("/password")
	public ResponseEntity<Boolean> isValid(@RequestBody @Valid PasswordDTO dto){	

		final Boolean response = service.validate(dto);
		return response ? ResponseEntity.ok().body(response) : ResponseEntity.badRequest().body(response);		 
	}
	
}
