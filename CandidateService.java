package com.xworkz.interviewApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.interviewApp.dao.CandidateDAO;
import com.xworkz.interviewApp.dto.CandidateDTO;

@Service
public class CandidateService {
	private static final Logger slf4jLogger=LoggerFactory.getLogger(CandidateService.class);
	@Autowired
	private CandidateDAO dao;
	@Autowired
	private MailSender mailSender;

	public CandidateService() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	public String candidateService(CandidateDTO dto) {
		String resultFromDao = null;
		resultFromDao=dao.save(dto);
		  //send mail to user
		  SimpleMailMessage mailMessage=new SimpleMailMessage();
		  slf4jLogger.info(dto.getEmail());
		  mailMessage.setTo(dto.getEmail());
		  mailMessage.setSubject("Registration Confirmation Mail");
		  mailMessage.setText("Hi "+dto.getName()+"\n"+" Registered successful "+"username "+dto.getUser()+"password "+dto.getPassword()+"please click below link to login "+"http://localhost:8080/interview_proj/login.do?user="+dto.getUser() ); 
		  mailSender.send(mailMessage);
		  slf4jLogger.info("msg sent");
		 
		return resultFromDao;
	}
}
