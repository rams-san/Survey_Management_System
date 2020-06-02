package com.capgemini.survey.service;

import com.capgemini.survey.dao.AdminDao;
import com.capgemini.survey.factory.Factory;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean serviceLoginAdmin(String userName, String password) {
		AdminDao adminDao = Factory.getAdminDaoInstance();
		return  adminDao.loginAdmin(userName,password);	
	}
}
