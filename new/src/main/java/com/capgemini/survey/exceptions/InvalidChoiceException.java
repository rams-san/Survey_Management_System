package com.capgemini.survey.exceptions;


public class InvalidChoiceException extends RuntimeException{
	private static final long serialVersionUID = 5760390115163605890L;

	public InvalidChoiceException(String message) {
		super(message);
	}
}
