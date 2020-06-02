package com.capgemini.survey.validations;

public interface InputValidations {
	public boolean idValidation(String id);
	
	public boolean nameValidation(String name);

	public boolean localDateValidation(String date);

	public boolean choiceValidation(String choice);
	
	public boolean choice1Validation(String choice1);
	
	public boolean choice2Validation(String choice1);
	
	public boolean choice3Validation(String choice1);
	
	public boolean choice4Validation(String choice1);
	
	public boolean choice5Validation(String choice1);

	public boolean emailValidation(String email);
	
	public boolean passwordValidation(String password);
	
	public boolean userNameValidation(String userName);
	
	public boolean titleValidation(String title); 
	
	public boolean descriptionValidation(String description);
	
	public boolean questionValidation(String question);
	
	public boolean answerValidation(String answer);
}