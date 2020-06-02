package com.capgemini.survey.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.SurveyAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.repository.SurveyRepository;
import com.capgemini.survey.validations.InputValidations;

public class SurveyDaoImpl implements SurveyDao {
	static List<SurveyInfoBean> surveyList = new SurveyRepository().surveyTable();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	ArrayList<String> titleList = new ArrayList<>();
	ArrayList<String> questionList = new ArrayList<>();
	int counter = 0;

	/**
	 * This method is use to get surveys record based on their titles.
	 * 
	 * @param surveyTitle is the parameter to getSurvey method.
	 * @return surveyInfoBean value if survey title is present else throw
	 *         NotFoundException.
	 */
	@Override
	public SurveyInfoBean getSurvey(String surveyTitle) {
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			if (surveyInfoBean.getSurveyTitle().equals(surveyTitle)) {
				counter++;
				return surveyInfoBean;
			}
		}
		throw new NotFoundException("Survey doesn't exists");
	}

	/**
	 * This method is use to search survey title.
	 * 
	 * @param surveyTitle is the parameter to searchSurvey method.
	 * @return true value if survey title is present else throw
	 *         SurveyAlreadyExistsException.
	 */
	@Override
	public boolean searchSurvey(String surveyTitle) {
		Iterator<SurveyInfoBean> surveyInfoBean4 = surveyList.iterator();
		while (surveyInfoBean4.hasNext()) {
			SurveyInfoBean compare2 = surveyInfoBean4.next();
			if (compare2.getSurveyTitle().equals(surveyTitle)) {
				counter++;
				throw new SurveyAlreadyExistsException("\nSurvey already exists !!");
			}
		}
		return (counter == 0);
	}

	/**
	 * This method is use to search survey title.
	 * 
	 * @param surveyTitle is the parameter to searchSurvey1 method.
	 * @return true value if survey title is present else throw NotFoundException.
	 */
	@Override
	public boolean searchSurvey1(String surveyTitle) {
		Iterator<SurveyInfoBean> surveyInfoBean4 = surveyList.iterator();
		while (surveyInfoBean4.hasNext()) {
			SurveyInfoBean compare2 = surveyInfoBean4.next();
			if (compare2.getSurveyTitle().equals(surveyTitle)) {
				counter++;
				return (counter != 0);
			}
		}
		throw new NotFoundException("Survey doesn't exists !!");
	}

	/**
	 * This method is use to add surveys based on their id's.
	 * 
	 * @param surveyTitle,surveyDescription,surveyQuestion1,surveyQuestion2,surveyQuestion3,surveyQuestion4,surveyQuestion5,surveyQuestion6,surveyQuestion7,surveyQuestion8,surveyQuestion9,surveyQuestion10 are
	 *                                                                                                                                                                                                       the
	 *                                                                                                                                                                                                       parameters
	 *                                                                                                                                                                                                       to
	 *                                                                                                                                                                                                       addSurvey
	 *                                                                                                                                                                                                       method.
	 * @return true.
	 */
	@Override
	public boolean addSurvey(SurveyInfoBean surveyInfoBean) {
		ArrayList<SurveyInfoBean> list3 = new ArrayList<>();
		list3.add(surveyInfoBean);
		surveyList.addAll(list3);
		return true;
	}

	/**
	 * This method is use to update surveys based on their id's.
	 * 
	 * @param surveyTitle,surveyDescription,surveyQuestion1,surveyQuestion2,surveyQuestion3,surveyQuestion4,surveyQuestion5,surveyQuestion6,surveyQuestion7,surveyQuestion8,surveyQuestion9,surveyQuestion10 are
	 *                                                                                                                                                                                                       the
	 *                                                                                                                                                                                                       parameters
	 *                                                                                                                                                                                                       to
	 *                                                                                                                                                                                                       updateSurvey
	 *                                                                                                                                                                                                       method.
	 * @return true.
	 */
	@Override
	public boolean updateSurvey(String surveyTitle, SurveyInfoBean surveyInfoBean) {
		for (SurveyInfoBean surveyInfoBean1 : surveyList) {
			if (surveyInfoBean1.getSurveyTitle().equals(surveyTitle)) {	
				surveyInfoBean1.setSurveyDescription(surveyInfoBean.getSurveyDescription());
				surveyInfoBean1.setSurveyQuestion1(surveyInfoBean.getSurveyQuestion1());
				surveyInfoBean1.setSurveyQuestion2(surveyInfoBean.getSurveyQuestion2());
				surveyInfoBean1.setSurveyQuestion3(surveyInfoBean.getSurveyQuestion3());
				surveyInfoBean1.setSurveyQuestion4(surveyInfoBean.getSurveyQuestion4());
				surveyInfoBean1.setSurveyQuestion5(surveyInfoBean.getSurveyQuestion5());
				surveyInfoBean1.setSurveyQuestion6(surveyInfoBean.getSurveyQuestion6());
				surveyInfoBean1.setSurveyQuestion7(surveyInfoBean.getSurveyQuestion7());
				surveyInfoBean1.setSurveyQuestion8(surveyInfoBean.getSurveyQuestion8());
				surveyInfoBean1.setSurveyQuestion9(surveyInfoBean.getSurveyQuestion9());
				surveyInfoBean1.setSurveyQuestion10(surveyInfoBean.getSurveyQuestion10());

			}
		}		return true;
	}

	/**
	 * This method is use to delete surveys based on their titles.
	 * 
	 * @param surveyTitle is the parameter to deleteSurvey method.
	 * @return boolean value based on condition, returns true if survey is deleted
	 *         else throw NotFoundException.
	 */
	@Override
	public boolean deleteSurvey(String surveyTitle) {
		Iterator<SurveyInfoBean> surveyInfoBean = surveyList.iterator();
		while (surveyInfoBean.hasNext()) {
			SurveyInfoBean itr1 = surveyInfoBean.next();
			if (itr1.getSurveyTitle().equals(surveyTitle)) {
				counter++;
				surveyInfoBean.remove();
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Survey doesn't exists");
		}
		return true;
	}

	/**
	 * This method is use to get all Surveys records.
	 * 
	 * @return surveyList if list is not empty else returns empty list
	 */
	@Override
	public List<SurveyInfoBean> getAllSurveys() {
		if (!surveyList.isEmpty()) {
			return surveyList;
		}
		return Collections.emptyList();
	}

	/**
	 * This method is use to get list of titles.
	 * 
	 * @return titleList.
	 */
	@Override
	public List<String> getListOfTitle() {
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			String str = surveyInfoBean.getSurveyTitle();
			titleList.add(str);
		}
		return titleList;
	}

	/**
	 * This method is use to get survey questions based on respond title.
	 * 
	 * @param respondTitle is the parameter to getSurveyQuestions.
	 * @return questionList if respond title is present else throw
	 *         NotFoundException.
	 */
	@Override
	public List<String> getSurveyQuestions(String respondTitle) {
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			if (surveyInfoBean.getSurveyTitle().equals(respondTitle)) {
				questionList.add((surveyInfoBean.getSurveyQuestion1()));
				questionList.add((surveyInfoBean.getSurveyQuestion2()));
				questionList.add((surveyInfoBean.getSurveyQuestion3()));
				questionList.add((surveyInfoBean.getSurveyQuestion4()));
				questionList.add((surveyInfoBean.getSurveyQuestion5()));
				questionList.add((surveyInfoBean.getSurveyQuestion6()));
				questionList.add((surveyInfoBean.getSurveyQuestion7()));
				questionList.add((surveyInfoBean.getSurveyQuestion8()));
				questionList.add((surveyInfoBean.getSurveyQuestion9()));
				questionList.add((surveyInfoBean.getSurveyQuestion10()));
				counter++;
			}
		}
		if (counter != 0) {
			return questionList;
		} else {
			throw new NotFoundException("\nSurvey title doesn't exists");
		}
	}

	@Override
	public boolean compareDistribution() {
		RespondDaoImpl respondDaoImpl = new RespondDaoImpl();
		List<String> compareList = respondDaoImpl.getListOfRespondTitle();
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			for (int i = 0; i < compareList.size(); i++) {
				if (surveyInfoBean.getSurveyTitle().equals(compareList.get(i))) {
					counter++;
				}
			}
		}
		return (counter == 0);
	}
}
