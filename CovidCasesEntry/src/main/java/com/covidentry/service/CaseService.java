package com.covidentry.service;

import java.util.List;

import com.covidentry.model.Case;

public interface CaseService {
	public List<Case> getAllCases();
	public int addCaseByCountry(Case caseObj);
	public int updateCaseByCountryId(Case caseObj);
	public int deleteCaseByCountryId(Long countryId);
	public Case getCaseByCountryId(Long countryId);
}
