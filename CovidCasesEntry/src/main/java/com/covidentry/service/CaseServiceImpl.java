package com.covidentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidentry.dao.CaseDao;
import com.covidentry.model.Case;

@Service("caseService")
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseDao caseDao;
	
	@Override
	public List<Case> getAllCases() {
		List<Case> list = caseDao.getAllCases();
		return list;
	}

	@Override
	public int addCaseByCountry(Case caseObj) {
		return caseDao.addCaseByCountry(caseObj);
	}

	@Override
	public int updateCaseByCountryId(Case caseObj) {
		return caseDao.updateCaseByCountryId(caseObj);
	}

	@Override
	public int deleteCaseByCountryId(Long countryId) {
		return caseDao.deleteCaseByCountryId(countryId);
	}

	@Override
	public Case getCaseByCountryId(Long countryId) {
		Case details = caseDao.getCaseByCountryId(countryId);
		return details;
	}
}
