package com.xworkz.interviewApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.interviewApp.dto.CandidateDTO;
import com.xworkz.interviewApp.service.PasswordChangeService;

@Repository
public class CandidateDAO {
	private static final Logger slf4jLogger=LoggerFactory.getLogger(CandidateDAO.class);

	@Autowired
	private SessionFactory factory;
	private Transaction transaction;
	private Session session;

	public CandidateDAO() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	public String save(CandidateDTO dto) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			if (dto != null)
				session.save(dto);

			transaction.commit();
		} catch (Exception e) {
			slf4jLogger.info("Data cannot be saved into  db");
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return "Successfuly saved the data";
	}
}
