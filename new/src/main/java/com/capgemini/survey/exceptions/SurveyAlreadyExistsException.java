package com.capgemini.survey.exceptions;

public class SurveyAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = -6712897080886910154L;

	public SurveyAlreadyExistsException(String message) {
		super(message);
	}
}
