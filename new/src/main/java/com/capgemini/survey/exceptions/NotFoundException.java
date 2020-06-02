package com.capgemini.survey.exceptions;

public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 9198054144936752403L;

	public NotFoundException(String message) {
		super(message);
	}
}
