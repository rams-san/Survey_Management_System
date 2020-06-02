package com.capgemini.survey.exceptions;

public class SurveyorAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1522745634622852747L;

	public SurveyorAlreadyExistsException(String message) {
		super(message);
	}
}
