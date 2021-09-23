package com.raiden.services.exceptions;

public class DataIntegrrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegrrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
