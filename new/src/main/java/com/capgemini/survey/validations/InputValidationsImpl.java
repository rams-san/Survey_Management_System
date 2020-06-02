package com.capgemini.survey.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationsImpl implements InputValidations {

	Pattern pat = null;
	Matcher mat = null;

	public boolean idValidation(String id) {
		pat = Pattern.compile("\\d{2,4}");
		mat = pat.matcher(id);
		return mat.matches();
	}

	public boolean nameValidation(String name) {
		if (!name.equals("null")) {
			pat = Pattern.compile("^[a-zA-Z a-zA-Z a-zA-Z]{2,30}$");
			mat = pat.matcher(name);
			return mat.matches();
		}
		return false;
	}

	public boolean localDateValidation(String date) {
		return (date.matches("^(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$"));
	}

	public boolean choiceValidation(String choice) {
		pat = Pattern.compile("[1-2]");
		mat = pat.matcher(choice);
		return mat.matches();
	}

	public boolean choice1Validation(String choice1) {
		pat = Pattern.compile("[1-6]");
		mat = pat.matcher(choice1);
		return mat.matches();
	}

	public boolean choice2Validation(String choice1) {
		pat = Pattern.compile("[1-9]");
		mat = pat.matcher(choice1);
		return mat.matches();
	}

	public boolean choice3Validation(String choice1) {
		pat = Pattern.compile("[1-3]");
		mat = pat.matcher(choice1);
		return mat.matches();
	}

	public boolean choice5Validation(String choice1) {
		pat = Pattern.compile("[1]");
		mat = pat.matcher(choice1);
		return mat.matches();
	}

	public boolean choice4Validation(String choice1) {
		pat = Pattern.compile("([1-9]|1[0-9]|2[0-1])");
		mat = pat.matcher(choice1);
		return mat.matches();
	}

	public boolean emailValidation(String email) {
		pat = Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
		mat = pat.matcher(email);
		return mat.matches();
	}

	public boolean passwordValidation(String password) {
		pat = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[*@#$%!]).{8,40})");
		mat = pat.matcher(password);
		return mat.matches();
	}

	public boolean userNameValidation(String userName) {
		if (!userName.equals("null")) {
			pat = Pattern.compile("[A-Za-z0-9_]{1,20}");
			mat = pat.matcher(userName);
			return mat.matches();
		}
		return false;
	}

	public boolean titleValidation(String title) {
		if (!title.equals("null")) {
			pat = Pattern.compile("[a-zA-Z a-zA-Z]{1,20}");
			mat = pat.matcher(title);
			return mat.matches();
		}
		return false;
	}

	public boolean descriptionValidation(String description) {
		if (!description.equals("null")) {
			pat = Pattern.compile("[a-zA-Z .]*");
			mat = pat.matcher(description);
			return mat.matches();
		}
		return false;
	}

	public boolean questionValidation(String question) {
		if (!question.equals("null")) {
			pat = Pattern.compile("[a-zA-Z ?]{10,50}]*");
			mat = pat.matcher(question);
			return mat.matches();
		}
		return false;
	}

	public boolean answerValidation(String answer) {
		if (!answer.equals("null")) {
			pat = Pattern.compile("([a-zA-Z .]{1,140}|[1-5][0-9]|6[0-5]|[0-9])");
			mat = pat.matcher(answer);
			return mat.matches();
		}
		return false;
	}
}
