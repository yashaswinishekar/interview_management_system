package com.xworkz.interviewApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/location") // no need of .do extension
public class LocationController {

	@RequestMapping(value = "/getLocation.do", method = RequestMethod.GET)
	private ResponseEntity<Object> getLocation() {
		RestTemplate rest = new RestTemplate();
		String uri = "https://restcountries.eu/rest/v2/all";
		Object dto = rest.getForObject(uri, Object.class);
		System.out.println(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}
}
