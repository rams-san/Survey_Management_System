package com.capgemini.survey.dao;

import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.repository.AdminRepository;
import com.capgemini.survey.validations.InputValidations;

public class AdminDaoImpl implements AdminDao {

	public static final org.apache.log4j.Logger logger = Logger.getLogger(AdminDaoImpl.class);
	static List<AdminInfoBean> adminList = new AdminRepository().adminTable();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	int counter = 0;
	Scanner sc = new Scanner(System.in);

	/**
	 * This method is use to login as admin.
	 * 
	 * @param admin is the parameter to loginAdmin method.
	 * @return boolean value base on condition, returns true if login is successful
	 *         else returns false.
	 */
	@Override
	public boolean loginAdmin(String userName, String password) {
		for (AdminInfoBean adminInfoBean : adminList) {
			if ((adminInfoBean.getAdminUserName().equals(userName))
					&& (adminInfoBean.getAdminPassword().equals(password))) {
				return true;
			}
		}
		return false;
	}
}
