package com.covidentry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covidentry.model.Case;
import com.covidentry.service.CaseService;

@RestController
public class CaseController {
	@Autowired
	private CaseService caseService;
	
	@RequestMapping(value="/case", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Case>> getAllCases(){
		HttpHeaders header = new HttpHeaders();
		List<Case> caseObj = caseService.getAllCases();
		if(caseObj == null) {
			return new ResponseEntity<List<Case>>(HttpStatus.NOT_FOUND);
		}
		header.add("Number Of Records Found", String.valueOf(caseObj.size()));
		return new ResponseEntity<List<Case>>(caseObj, header, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/case/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Case> getCaseByCountryId(@PathVariable("id") Long countryId) {
	  Case caseObj = caseService.getCaseByCountryId(countryId);
	  if (caseObj == null) {
	   return new ResponseEntity<Case>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Case>(caseObj, HttpStatus.OK);
	 }
	
	@RequestMapping(value="/case/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Case> deleteCaseByCountryId(@PathVariable("id") Long countryId){
		HttpHeaders header = new HttpHeaders();
		Case caseObj = caseService.getCaseByCountryId(countryId);
		if(caseObj == null) {
			return new ResponseEntity<Case>(HttpStatus.NOT_FOUND);
		}
		caseService.deleteCaseByCountryId(countryId);
		header.add("Case Deleted Successfully", String.valueOf(countryId));
		return new ResponseEntity<Case>(caseObj, header, HttpStatus.NO_CONTENT);
	 }

	@RequestMapping(value = "/case", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Case> addCaseByCountry(@RequestBody Case caseObj) { System.out.println("Inside");
		HttpHeaders headers = new HttpHeaders();
		if (caseObj == null) {
		   return new ResponseEntity<Case>(HttpStatus.BAD_REQUEST);
		}
		caseService.addCaseByCountry(caseObj);
		headers.add("Case Created  - ", String.valueOf(caseObj.getCountryId()));
		return new ResponseEntity<Case>(caseObj, headers, HttpStatus.CREATED);
	 }
	
	@RequestMapping(value = "/case/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Case> updateCaseByCountryId(@PathVariable("id") Long countryId, @RequestBody Case Case) {
		HttpHeaders headers = new HttpHeaders();
		Case isExist = caseService.getCaseByCountryId(countryId);
		if (isExist == null) {   
			return new ResponseEntity<Case>(HttpStatus.NOT_FOUND);
		} else if (Case == null) {
			return new ResponseEntity<Case>(HttpStatus.BAD_REQUEST);
		}
		caseService.updateCaseByCountryId(Case);
		headers.add("Case Updated  - ", String.valueOf(countryId));
		return new ResponseEntity<Case>(Case, headers, HttpStatus.OK);
	 }
}
