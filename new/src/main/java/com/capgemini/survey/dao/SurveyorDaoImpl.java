package com.capgemini.survey.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.SurveyorAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.repository.SurveyorRepository;

public class SurveyorDaoImpl implements SurveyorDao {
	static List<SurveyorInfoBean> surveyorList = new SurveyorRepository().surveyorTable();
	int counter = 0;

	/**
	 * This method is use to login as surveyor.
	 * 
	 * @param surveyor is the parameter to loginSurveyor method.
	 * @return boolean value base on condition, returns true if login is successful
	 *         else returns false.
	 */
	@Override
	public boolean loginSurveyor(String userName, String password) {
		for (SurveyorInfoBean surveyorInfoBean : surveyorList) {
			if ((surveyorInfoBean.getSurveyorUserName().equals(userName))
					&& (surveyorInfoBean.getSurveyorPassword().equals(password))) {
				counter++;
			}
		}
		return (counter != 0);
	}

	/**
	 * This method is use to get surveyors record based on their id's.
	 * 
	 * @param surveyorId is the parameter to getSurveyor method.
	 * @return surveyorInfoBean value if surveyorId is present else throw NotFoundException
	 */
	@Override
	public SurveyorInfoBean getSurveyor(int surveyorId) {
		for (SurveyorInfoBean surveyorInfoBean : surveyorList) {
			if (surveyorInfoBean.getSurveyorId() == surveyorId) {
				counter++;
				return surveyorInfoBean;
			}
		}
		throw new NotFoundException("Surveyor doesn't exists !!");
	}

	/**
	 * This method is use to search surveyor id.
	 * 
	 * @param surveyorId is the parameter to addSurveyor method.
	 * @return true else throw SurveyorAlreadyExistsException.
	 */
	@Override
	public boolean searchSurveyor(int surveyorId) {
		Iterator<SurveyorInfoBean> surveyorInfoBean4 = surveyorList.iterator();
		while (surveyorInfoBean4.hasNext()) {
			SurveyorInfoBean compare1 = surveyorInfoBean4.next();
			if (compare1.getSurveyorId() == surveyorId) {
				counter++;
				throw new SurveyorAlreadyExistsException("\nSurveyor already exists");
			}
		}
		return (counter == 0);
	}

	/**
	 * This method is use to search surveyor id.
	 * 
	 * @param surveyorId is the parameter to addSurveyor method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean searchSurveyor1(int surveyorId) {
		Iterator<SurveyorInfoBean> surveyorInfoBean4 = surveyorList.iterator();
		while (surveyorInfoBean4.hasNext()) {
			SurveyorInfoBean compare1 = surveyorInfoBean4.next();
			if (compare1.getSurveyorId() == surveyorId) {
				counter++;
				return (counter != 0);
			}
		}
		throw new NotFoundException("\nSurveyor doesn't exists !!");
	}
	
	/**
	 * This method is use to add surveyors based on their id's.
	 * 
	 * @param surveyorId,surveyorName,surveyorEmail,surveyorUserName,surveyorPassword,surveyorDob are the parameters to addSurveyor method.
	 * @return true.
	 */
	@Override
	public boolean addSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName,
			String surveyorPassword, LocalDate surveyorDob) {
		SurveyorInfoBean surveyorInfoBean = Factory.getSurveyorInfoBeanInstance();
		surveyorInfoBean.setSurveyorId(surveyorId);
		surveyorInfoBean.setSurveyorName(surveyorName);
		surveyorInfoBean.setSurveyorEmail(surveyorEmail);
		surveyorInfoBean.setSurveyorUserName(surveyorUserName);
		surveyorInfoBean.setSurveyorPassword(surveyorPassword);
		surveyorInfoBean.setSurveyorDob(surveyorDob);
		ArrayList<SurveyorInfoBean> list = new ArrayList<>();
		list.add(surveyorInfoBean);
		surveyorList.addAll(list);
		return true;
	}

	/**
	 * This method is use to update surveyors based on their id's.
	 * 
	 * @param surveyorId,surveyorName,surveyorEmail,surveyorUserName,surveyorPassword,surveyorDob are the parameters to updateSurveyor method.
	 * @return true.
	 */
	@Override
	public boolean updateSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob) {
			for (SurveyorInfoBean surveyorInfoBean : surveyorList) {
				if (surveyorInfoBean.getSurveyorId() == surveyorId) {		
					surveyorInfoBean.setSurveyorName(surveyorName);
					surveyorInfoBean.setSurveyorEmail(surveyorEmail);
					surveyorInfoBean.setSurveyorUserName(surveyorUserName);
					surveyorInfoBean.setSurveyorUserName(surveyorPassword);
					surveyorInfoBean.setSurveyorDob(surveyorDob);
				}
			}
			return true;
	}

	/**
	 * This method is use to delete surveyors based on their id's.
	 * 
	 * @param surveyorId is the parameter to deleteSurveyor method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean deleteSurveyor(int surveyorId) {
		Iterator<SurveyorInfoBean> surveyorInfoBean = surveyorList.iterator();
		while (surveyorInfoBean.hasNext()) {
			SurveyorInfoBean itr1 = surveyorInfoBean.next();
			if (itr1.getSurveyorId() == surveyorId) {
				counter++;
				surveyorInfoBean.remove();
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Surveyor doesn't exists !!");
		}
		return true;
	}

	/**
	 * This method is use to get all Surveyors records.
	 * 
	 * @return surveyorList if list is not empty else returns empty list
	 */
	@Override
	public List<SurveyorInfoBean> getAllSurveyors() {
		if (!surveyorList.isEmpty()) {
			return surveyorList;
		}
		return Collections.emptyList();
	}
}
