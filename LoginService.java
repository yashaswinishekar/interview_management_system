package com.xworkz.interviewApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.interviewApp.dao.LoginDAO;
import com.xworkz.interviewApp.dto.CandidateDTO;
import com.xworkz.interviewApp.dto.LoginDTO;

@Service
public class LoginService {
private static final Logger slf4jLogger=LoggerFactory.getLogger(LoginService.class);
@Autowired
	private LoginDAO dao;

	public LoginService() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	public CandidateDTO loginSuccessService(LoginDTO dto) {
		CandidateDTO dtoFromDao = dao.fetchSuccessDTO(dto);
		return dtoFromDao;
	}
	

	public CandidateDTO loginService(String userId) {
		CandidateDTO dtoFromDao = dao.fetchDTO(userId);
		return dtoFromDao;
	}

	public boolean updateService(CandidateDTO dto) {
		String dtoFromDao = dao.updateDTO(dto);
		return true;
	}
}
