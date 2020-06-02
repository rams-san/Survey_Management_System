package com.capgemini.survey.exceptions;

public class RespondentAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 8638593721492138298L;

	public RespondentAlreadyExistsException(String message) {
		super(message);
	}
}
