package com.covidentry.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Case {
	private Long countryId;
	private String countryName;
	private Long totalCases;
	private Long newCases;
	private Long totalDeaths;
	private Long newDeaths;
	private Long totalRecovered;
	private Long activeCases;
	private Long seriousCritical;
	private Long totCasesMpop;
	private Long deathsMpop;
	private Long totalTests;
	private Long testsMpop;
	
	public Case() {
		
	}
	 
	@JsonCreator
	public Case(@JsonProperty("countryId") Long countryId, @JsonProperty("countryName") String countryName,
			@JsonProperty("totalCases") Long totalCases, @JsonProperty("newCases") Long newCases,
			@JsonProperty("totalDeaths") Long totalDeaths, @JsonProperty("newDeaths") Long newDeaths,
			@JsonProperty("totalRecovered") Long totalRecovered, @JsonProperty("activeCases") Long activeCases,
			@JsonProperty("seriousCritical") Long seriousCritical, @JsonProperty("totCasesMpop") Long totCasesMpop,
			@JsonProperty("deathsMpop") Long deathsMpop, @JsonProperty("totalTests") Long totalTests,
			@JsonProperty("testsMpop") Long testsMpop) {
		
		this.countryId = countryId;	this.countryName = countryName; this.totalCases = totalCases;
		this.newCases = newCases;  this.totalDeaths = totalDeaths; this.newDeaths = newDeaths;
		this.totalRecovered = totalRecovered;  this.activeCases = activeCases; 
		this.seriousCritical = seriousCritical;  this.totCasesMpop = totCasesMpop;  this.deathsMpop = deathsMpop;
		this.totalTests = totalTests;  this.testsMpop = testsMpop;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("country id :- "+getCountryId());
		builder.append("Country Name :- "+getCountryName());
		builder.append("Total Cases :- "+getTotalCases());
		builder.append("New Cases :- "+getNewCases());
		
		builder.append("Total Deaths :- "+getTotalDeaths());
		builder.append("New Deaths :- "+getNewDeaths());
		builder.append("Total Recovered :- "+getTotalRecovered());
		builder.append("Active Cases :- "+getActiveCases());
		
		builder.append("Seroius Critical :- "+getSeriousCritical());
		builder.append("Total Cases/ 1M POP :- "+getTotCasesMpop());
		builder.append("Total Deaths/ 1M POP :- "+getDeathsMpop());
		builder.append("Total Tests :- "+getTotalTests());
		
		builder.append("Test/1M POP :- "+getTestsMpop());
		return builder.toString();
	}
	
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Long totalCases) {
		this.totalCases = totalCases;
	}

	public Long getNewCases() {
		return newCases;
	}

	public void setNewCases(Long newCases) {
		this.newCases = newCases;
	}

	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Long getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Long newDeaths) {
		this.newDeaths = newDeaths;
	}

	public Long getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Long totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public Long getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(Long activeCases) {
		this.activeCases = activeCases;
	}

	public Long getSeriousCritical() {
		return seriousCritical;
	}

	public void setSeriousCritical(Long seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public Long getTotCasesMpop() {
		return totCasesMpop;
	}

	public void setTotCasesMpop(Long totCasesMpop) {
		this.totCasesMpop = totCasesMpop;
	}

	public Long getDeathsMpop() {
		return deathsMpop;
	}

	public void setDeathsMpop(Long deathsMpop) {
		this.deathsMpop = deathsMpop;
	}

	public Long getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(Long totalTests) {
		this.totalTests = totalTests;
	}

	public Long getTestsMpop() {
		return testsMpop;
	}

	public void setTestsMpop(Long testsMpop) {
		this.testsMpop = testsMpop;
	}
}
