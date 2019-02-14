package com.xworkz.interviewApp.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.interviewApp.dto.CandidateDTO;
import com.xworkz.interviewApp.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	private static final Logger slf4jLogger=LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService service;

	public LoginController() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	/*@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginController(LoginDTO dto) {

		ModelAndView modelAndView = new ModelAndView();
		CandidateDTO dtoFromService = service.loginService(dto);
		if (dtoFromService != null) {
			if (dtoFromService.getNewUser()) {
				boolean resultFromService = service.updateService(dtoFromService);
				modelAndView.setViewName("/passwordChange.jsp");
				modelAndView.addObject("cdto", resultFromService);
			} else {
				modelAndView.setViewName("/loginSuccess.jsp");
				modelAndView.addObject("ldto", "login successful");
			}
		} else {
			modelAndView.setViewName("/login.jsp");
			modelAndView.addObject("failure", "username and password doesnot match");
		}
		return modelAndView;
	}*/
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String changePassword(HttpServletRequest req){
		String userId=req.getParameter("user");
		slf4jLogger.info(userId);
		CandidateDTO dtoFromService = service.loginService(userId);
		if (dtoFromService != null) {
			if (dtoFromService.getNewUser()) {
				boolean resultFromService = service.updateService(dtoFromService);
				req.setAttribute("cdto", resultFromService);
				return "/passwordChange.jsp";
			} else {
				req.setAttribute("ldto", "login successful");
				return "/loginSuccess.jsp";

			}
		} else {
			req.setAttribute("failure", "username and password doesnot match");
			return "/CandidateHomePage.jsp";

		}
		
	}

}
