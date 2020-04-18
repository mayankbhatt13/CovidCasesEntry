package com.covidentry.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.covidentry.model.Case;

@Repository("caseDao")
public class CaseDaoImpl implements CaseDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Case> getAllCases() {
		List<Case> caseList = null;
		try {
			caseList = jdbcTemplate.query("SELECT * FROM cases", new BeanPropertyRowMapper<Case>(Case.class));
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return caseList;
	}
	
	@Override
	public int addCaseByCountry(Case caseObj) {
		int flag = jdbcTemplate.update("INSERT INTO cases(countryId, countryName, totalCases, newCases, totalDeaths, newDeaths, "
				+ "totalRecovered, activeCases, seriousCritical, totCasesMpop, deathsMpop, totalTests, testsMpop) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] {caseObj.getCountryId(),caseObj.getCountryName(), caseObj.getTotalCases(), caseObj.getNewCases(), caseObj.getTotalDeaths(),
						caseObj.getNewDeaths(), caseObj.getTotalRecovered(), caseObj.getActiveCases(), caseObj.getSeriousCritical(), caseObj.getTotCasesMpop(),
						caseObj.getDeathsMpop(), caseObj.getTotalTests(), caseObj.getTestsMpop()});
		return flag;
	}

	@Override
	public int updateCaseByCountryId(Case caseObj) {
		int flag = jdbcTemplate.update("UPDATE cases set countryName=?, totalCases=?, newCases=?, totalDeaths=?, newDeaths=?, "
				+ "totalRecovered=?, activeCases=?, seriousCritical=?, totCasesMpop=?, deathsMpop=?, totalTests=?, testsMpop=? WHERE countryId = ?",
				new Object[]{caseObj.getCountryName(), caseObj.getTotalCases(), caseObj.getNewCases(), caseObj.getTotalDeaths(),
						caseObj.getNewDeaths(), caseObj.getTotalRecovered(), caseObj.getActiveCases(), caseObj.getSeriousCritical(), caseObj.getTotCasesMpop(),
						caseObj.getDeathsMpop(), caseObj.getTotalTests(), caseObj.getTestsMpop(), caseObj.getCountryId()});
		return flag;
	}

	@Override
	public int deleteCaseByCountryId(Long countryId) {
		int flag = jdbcTemplate.update("DELETE FROM cases where countryId = ?", new Object[] {countryId});
		return flag;
	}

	@Override
	public Case getCaseByCountryId(Long countryId) {
		Case caseDetails = null;
		try {
			caseDetails = jdbcTemplate.queryForObject("SELECT * FROM cases where countryId = ?",
					new Object[] {countryId}, new BeanPropertyRowMapper<Case>(Case.class));
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return caseDetails;
	}
}
