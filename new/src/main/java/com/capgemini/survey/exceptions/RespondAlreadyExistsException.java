package com.capgemini.survey.exceptions;


public class RespondAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 391795202740143771L;

	public RespondAlreadyExistsException(String message) {
		super(message);
	}
}
