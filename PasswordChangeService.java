package com.xworkz.interviewApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.interviewApp.dao.PasswordChangeDAO;
import com.xworkz.interviewApp.dto.CandidateDTO;
import com.xworkz.interviewApp.dto.PasswordChangeDTO;

@Service
public class PasswordChangeService {
	private static final Logger slf4jLogger = LoggerFactory.getLogger(PasswordChangeService.class);

	@Autowired
	private PasswordChangeDAO dao;
	@Autowired
	private MailSender mailSender;


	public PasswordChangeService() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	public String passwordChangeService(PasswordChangeDTO dto) {
		String updatedDtoFromDao = null;
		CandidateDTO fetchDtoFromDao = null;
		fetchDtoFromDao = dao.fetchDTO(dto);
		if (fetchDtoFromDao != null) {
			//if (!(dto.getOldPassword().equals(dto.getPassword()))) {
				updatedDtoFromDao = dao.updateDTO(dto);
				 SimpleMailMessage mailMessage=new SimpleMailMessage();
				 slf4jLogger.info(fetchDtoFromDao.getEmail());
				  mailMessage.setTo(fetchDtoFromDao.getEmail());
				  mailMessage.setSubject("Change Password Confirmation Mail");
				  mailMessage.setText( "your password has been changed successfuly"); 
				  mailSender.send(mailMessage);
				  slf4jLogger.info("msg sent");
		/*	}
			else
			{
				System.out.println("your oldpassword and newpassword are same, change ur new password");
	
			}*/
		} else {
			slf4jLogger.info("your oldpassword doesnot match");
		}
		return updatedDtoFromDao;

	}
}
