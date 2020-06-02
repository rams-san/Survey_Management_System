package com.capgemini.survey.repository;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.factory.Factory;

/**
 * This method is use to create respondent table.
 * 
 * @return adminList
 */
public class AdminRepository {
	public List<AdminInfoBean> adminTable() {
		List<AdminInfoBean> adminList = new ArrayList<>();
		AdminInfoBean adminInfoBean = Factory.getAdminInfoBeanInstance();
		adminInfoBean.setAdminUserName("Suyash");
		adminInfoBean.setAdminPassword("Suyash@123");
		adminList.add(adminInfoBean);
		return adminList;
	}
}
