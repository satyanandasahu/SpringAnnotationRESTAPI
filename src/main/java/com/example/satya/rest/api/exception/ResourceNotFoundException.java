package com.example.satya.rest.api.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
