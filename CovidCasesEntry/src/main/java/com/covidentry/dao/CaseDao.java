package com.covidentry.dao;

import java.util.List;

import com.covidentry.model.Case;

public interface CaseDao {
	public List<Case> getAllCases();
	public int addCaseByCountry(Case caseObj);
	public int updateCaseByCountryId(Case caseObj);
	public int deleteCaseByCountryId(Long countryId);
	public Case getCaseByCountryId(Long countryId);
}
