package com.Backend.Inmobiliaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final String serialVersionUID = "";
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
