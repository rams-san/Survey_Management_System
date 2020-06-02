package com.capgemini.survey.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.RespondentAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.repository.RespondentRepository;

public class RespondentDaoImpl implements RespondentDao {
	static List<RespondentInfoBean> respondentList = new RespondentRepository().respondentTable();
	int counter = 0;

	/**
	 * This method is use to login as respondent.
	 * 
	 * @param respondent is the parameter to loginRespondent method.
	 * @return boolean value base on condition, returns true if login is successful
	 *         else returns false.
	 */
	@Override
	public boolean loginRespondent(String userName, String password) {
		for (RespondentInfoBean respondentInfoBean : respondentList) {
			if ((respondentInfoBean.getRespondentUserName().equals(userName))
					&& (respondentInfoBean.getRespondentPassword().equals(password))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is use to get respondents record based on their id's.
	 * 
	 * @param respondentId is the parameter to getRespondent method.
	 * @return respondentInfoBean if respondent is present else throw NotFoundException.
	 */
	@Override
	public RespondentInfoBean getRespondent(int respondentId) {
		for (RespondentInfoBean respondentInfoBean : respondentList) {
			if (respondentInfoBean.getRespondentId() == respondentId) {
				counter++;
				return respondentInfoBean;
			}
		}
			throw new NotFoundException("Respondent doesn't exists");
	}

	/**
	 * This method is use to add respondents based on their id's.
	 * 
	 * @param respondentId,respondentName,respondentEmail,respondentUserName,respondentPassword,respondentDob are the parameters to addRespondent method.
	 * @return true.
	 */
	@Override
	public boolean addRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob) {
			RespondentInfoBean respondentInfoBean = Factory.getRespondentInfoBeanInstance();
			respondentInfoBean.setRespondentId(respondentId);
			respondentInfoBean.setRespondentName(respondentName);
			respondentInfoBean.setRespondentEmail(respondentEmail);
			respondentInfoBean.setRespondentUserName(respondentUserName);
			respondentInfoBean.setRespondentPassword(respondentPassword);
			respondentInfoBean.setRespondentDob(respondentDob);
			ArrayList<RespondentInfoBean> list1 = new ArrayList<>();
			list1.add(respondentInfoBean);
			respondentList.addAll(list1);
			return true;
	}

	/**
	 * This method is use to search respondent id.
	 * 
	 * @param respondentId is the parameter to searchRespondent2 method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean searchRespondent(int respondentId) {
		Iterator<RespondentInfoBean> respondentInfoBean4 = respondentList.iterator();
		while (respondentInfoBean4.hasNext()) {
			RespondentInfoBean compare2 = respondentInfoBean4.next();
			if (compare2.getRespondentId() == respondentId) {
				counter++;
				throw new RespondentAlreadyExistsException("\nRespondent already exists !!");
			}
		}
		return (counter == 0);
	}
	
	/**
	 * This method is use to search respondent id.
	 * 
	 * @param respondentId is the parameter to searchRespondent1 method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean searchRespondent1(int respondentId) {
		Iterator<RespondentInfoBean> respondentInfoBean4 = respondentList.iterator();
		while (respondentInfoBean4.hasNext()) {
			RespondentInfoBean compare2 = respondentInfoBean4.next();
			if (compare2.getRespondentId() == respondentId) {
				counter++;
				return (counter != 0);
			}
		}
		throw new NotFoundException("\nRespondent doesn't exists !!");
	}
	
	/**
	 * This method is use to search respondent id.
	 * 
	 * @param respondentId is the parameter to searchRespondent2 method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean searchRespondent2(int respondentId) {
		Iterator<RespondentInfoBean> respondentInfoBean4 = respondentList.iterator();
		while (respondentInfoBean4.hasNext()) {
			RespondentInfoBean compare2 = respondentInfoBean4.next();
			if (compare2.getRespondentId() == respondentId) {
				counter++;
				return (counter != 0);
			}
		}
		throw new NotFoundException("\nRespondent Id doesn't exists !!");
	}
	
	/**
	 * This method is use to update respondents based on their id's.
	 * 
	 * @param respondentId,respondentName,respondentEmail,respondentUserName,respondentPassword,respondentDob are the parameters to updateRespondent method.
	 * @return true.
	 */
	@Override
	public boolean updateRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob){
			for (RespondentInfoBean respondentInfoBean : respondentList) {
				if (respondentInfoBean.getRespondentId() == respondentId) {
					respondentInfoBean.setRespondentName(respondentName);
					respondentInfoBean.setRespondentEmail(respondentEmail);
					respondentInfoBean.setRespondentUserName(respondentUserName);
					respondentInfoBean.setRespondentPassword(respondentPassword);
					respondentInfoBean.setRespondentDob(respondentDob);
				}
			}
			return true;
	}

	/**
	 * This method is use to delete respondents based on their id's.
	 * 
	 * @param respondentId is the parameter to deleteRespondent method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean deleteRespondent(int respondentId) {
		Iterator<RespondentInfoBean> respondentInfoBean = respondentList.iterator();
		while (respondentInfoBean.hasNext()) {
			RespondentInfoBean itr1 = respondentInfoBean.next();
			if (itr1.getRespondentId() == respondentId) {
				counter++;
				respondentInfoBean.remove();
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Respondent doesn't exists");
		}
		return true;
	}

	/**
	 * This method is use to get all respondents records.
	 * 
	 * @return respondentList if list is not empty else returns empty list.
	 */
	@Override
	public List<RespondentInfoBean> getAllRespondents() {
		if (!respondentList.isEmpty()) {
			return respondentList;
		}
		return Collections.emptyList();
	}

	@Override
	public boolean validRespondent(String userName, int respondId) {
		Iterator<RespondentInfoBean> respondentInfoBean = respondentList.iterator();
		while (respondentInfoBean.hasNext()) {
			RespondentInfoBean itr1 = respondentInfoBean.next();
			if ((itr1.getRespondentId() == respondId)&&(itr1.getRespondentUserName().equals(userName))) {
				counter++;
			}
		}
		if (counter == 0) {
			throw new NotFoundException("\nYou can't respond to others Id !!");
		}
		return true;
	}
}
