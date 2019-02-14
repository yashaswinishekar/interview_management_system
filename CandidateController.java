package com.xworkz.interviewApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.interviewApp.dto.CandidateDTO;
import com.xworkz.interviewApp.service.CandidateService;

@Controller
@RequestMapping("/")
public class CandidateController {
	private static final Logger slf4jLogger=LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	private CandidateService service;

	public CandidateController() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public ModelAndView candidateController(CandidateDTO dto) {
		String userId = null;
		String password = null;

		ModelAndView modelAndView = new ModelAndView();
		String ustr1 = dto.getName().substring(0, 3);
		String ustr2 = dto.getEmail().substring(0, 2);
		String ustr3 = dto.getDob().toString();
		int count = ustr3.length();
		String ustr4 = ustr3.substring(count - 2);
		userId = ustr1 + ustr2 + ustr4;

		String pstr1 = dto.getName().substring(0, 1);
		String pstr2 = pstr1.toUpperCase();
		String pstr3 = dto.getName().substring(1, 3);
		int firstTwoDigitsDate = dto.getDob().getDate();
		String lastThreeDigitsDate = ustr3.substring(count - 3);
		password = pstr2 + pstr3 + firstTwoDigitsDate + "$" + lastThreeDigitsDate;
		dto.setPassword(password);
		dto.setUser(userId);
		dto.setNewUser(true);
		slf4jLogger.info(userId);
		slf4jLogger.info(password);
		slf4jLogger.info(ustr3);
		String resultFromService = service.candidateService(dto);
		slf4jLogger.info(resultFromService);
		if (resultFromService != null) {
			slf4jLogger.info(resultFromService);
			modelAndView.setViewName("/CandidateSuccessPage.jsp");
			modelAndView.addObject("cdto", dto);
			return modelAndView;
		} else {
			modelAndView.setViewName("/CandidateRegistrationPage.jsp");
			modelAndView.addObject("failure", "failed to save");
			return modelAndView;
		}

	}
}
