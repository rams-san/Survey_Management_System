package com.capgemini.survey.beans;

import java.io.Serializable;

public class AdminInfoBean implements Serializable {
	private static final long serialVersionUID = 534161460742684512L;

	public AdminInfoBean() {
		//No argument Constructor
	}

	private String adminUserName;
	private String adminPassword;

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUsername) {
		this.adminUserName = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		String str = "\n";
		return "adminUserName=" + adminUserName + str + "adminPassword=" + adminPassword;
	}
}
