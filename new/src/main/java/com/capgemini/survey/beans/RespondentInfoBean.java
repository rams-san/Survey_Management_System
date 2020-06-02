package com.capgemini.survey.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class RespondentInfoBean implements Serializable {
	private static final long serialVersionUID = -5944260109905627909L;

	public RespondentInfoBean(int respondentId, String respondentName, String respondentEmail,
			String respondentUserName, String respondentPassword, LocalDate respondentDob) {

		this.respondentId = respondentId;
		this.respondentName = respondentName;
		this.respondentEmail = respondentEmail;
		this.respondentUserName = respondentUserName;
		this.respondentPassword = respondentPassword;
		this.respondentDob = respondentDob;
	}

	private int respondentId;
	private String respondentName;
	private String respondentEmail;
	private String respondentUserName;
	private String respondentPassword;
	private LocalDate respondentDob;

	public RespondentInfoBean() {

	}

	public int getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(int respondentId) {
		this.respondentId = respondentId;
	}

	public String getRespondentName() {
		return respondentName;
	}

	public void setRespondentName(String respondentName) {
		this.respondentName = respondentName;
	}

	public String getRespondentEmail() {
		return respondentEmail;
	}

	public void setRespondentEmail(String respondentEmail) {
		this.respondentEmail = respondentEmail;
	}

	public String getRespondentUserName() {
		return respondentUserName;
	}

	public void setRespondentUserName(String respondentUserName) {
		this.respondentUserName = respondentUserName;
	}

	public String getRespondentPassword() {
		return respondentPassword;
	}

	public void setRespondentPassword(String respondentPassword) {
		this.respondentPassword = respondentPassword;
	}

	public LocalDate getRespondentDob() {
		return respondentDob;
	}

	public void setRespondentDob(LocalDate respondentDob) {
		this.respondentDob = respondentDob;
	}

	@Override
	public String toString() {
		String str = "\n";
		return str + "respondentId = " + respondentId + str + "respondentName = " + respondentName +str + "respondentEmail = "
				+ respondentEmail + str + "respondentUserName = " + respondentUserName + str + "respondentPassword = "
				+ respondentPassword + str + "respondentDob = " + respondentDob + str;
	}
}
