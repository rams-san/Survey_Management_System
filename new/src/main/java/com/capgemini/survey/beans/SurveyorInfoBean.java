package com.capgemini.survey.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class SurveyorInfoBean implements Serializable {
	private static final long serialVersionUID = -4762389748919064891L;

	public SurveyorInfoBean() {

	}

	public SurveyorInfoBean(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName,
			String surveyorPassword, LocalDate surveyorDob) {

		this.surveyorId = surveyorId;
		this.surveyorName = surveyorName;
		this.surveyorEmail = surveyorEmail;
		this.surveyorUserName = surveyorUserName;
		this.surveyorPassword = surveyorPassword;
		this.surveyorDob = surveyorDob;
	}

	private int surveyorId;
	private String surveyorName;
	private String surveyorEmail;
	private String surveyorUserName;
	private String surveyorPassword;
	private LocalDate surveyorDob;

	public int getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(int surveyorId) {
		this.surveyorId = surveyorId;
	}

	public String getSurveyorName() {
		return surveyorName;
	}

	public void setSurveyorName(String surveyorName) {
		this.surveyorName = surveyorName;
	}

	public String getSurveyorEmail() {
		return surveyorEmail;
	}

	public void setSurveyorEmail(String surveyorEmail) {
		this.surveyorEmail = surveyorEmail;
	}

	public String getSurveyorUserName() {
		return surveyorUserName;
	}

	public void setSurveyorUserName(String surveyorUserName) {
		this.surveyorUserName = surveyorUserName;
	}

	public String getSurveyorPassword() {
		return surveyorPassword;
	}

	public void setSurveyorPassword(String surveyorPassword) {
		this.surveyorPassword = surveyorPassword;
	}

	public LocalDate getSurveyorDob() {
		return surveyorDob;
	}

	public void setSurveyorDob(LocalDate surveyorDob) {
		this.surveyorDob = surveyorDob;
	}

	@Override
	public String toString() {
		String str = "\n";
		return  str + "surveyorId = " + surveyorId + str + "surveyorName = " + surveyorName + str + "surveyorEmail = " + surveyorEmail
				+ str + "surveyorUserName = " + surveyorUserName + str + "surveyorPassword = " + surveyorPassword + str +"surveyorDob = "
				+ surveyorDob + str;
	}
}
