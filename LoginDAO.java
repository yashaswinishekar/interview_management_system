package com.xworkz.interviewApp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.interviewApp.dto.CandidateDTO;
import com.xworkz.interviewApp.dto.LoginDTO;

@Repository
public class LoginDAO {
	 private static final Logger slf4jLogger=LoggerFactory.getLogger(LoginDAO.class);

	@Autowired
	private SessionFactory factory;
	private Session session;

	public LoginDAO() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	public CandidateDTO fetchSuccessDTO(LoginDTO dto) {
		CandidateDTO dtoFromDb = null;
		try {
			String syntax = "select cdto from CandidateDTO cdto where cdto.user=:loginUser and cdto.password=:loginPwd";
			session = factory.openSession();
			Query query = session.createQuery(syntax);
			if (dto != null) {
				query.setParameter("loginUser", dto.getUserName());
				query.setParameter("loginPwd", dto.getPassword());
				// query.executeUpdate();
				dtoFromDb = (CandidateDTO) query.uniqueResult();
				return dtoFromDb;
			} else {
				slf4jLogger.info("dto object not found");
			}
		} catch (Exception e) {
			slf4jLogger.info("failed to get the data from the database");
		} finally {
			if (session != null)
				session.close();
		}
		return dtoFromDb;
	}

	public CandidateDTO fetchDTO(String userId) {
		CandidateDTO dtoFromDb = null;
		try {
			String syntax = "select cdto from CandidateDTO cdto where cdto.user=:loginUser";
			session = factory.openSession();
			Query query = session.createQuery(syntax);
			if (userId != null) {
				query.setParameter("loginUser", userId);
				// query.executeUpdate();
				dtoFromDb = (CandidateDTO) query.uniqueResult();
				return dtoFromDb;
			} else {
				slf4jLogger.info("dto object not found");
			}
		} catch (Exception e) {
			slf4jLogger.info("failed to get the data from the database");
		} finally {
			if (session != null)
				session.close();
		}
		return dtoFromDb;
	}

	public String updateDTO(CandidateDTO dto) {
		CandidateDTO dtoFromDb = null;
		try {
			String syntax = "update  CandidateDTO cdto set cdto.newUser=:nuser  where cdto.user=:cuser";
			session = factory.openSession();
			Query query = session.createQuery(syntax);
			if (dto != null) {
				query.setParameter("nuser", dto.setNewUser(false));

				query.setParameter("cuser", dto.getUser());

				query.executeUpdate();

				// dtoFromDb = (CandidateDTO) query.uniqueResult();

				return "data updated successfully";
			} else {
				slf4jLogger.info("dto object not found");
			}
		} catch (Exception e) {
			slf4jLogger.info("failed to update the dto in the database");
		} finally {
			if (session != null)
				session.close();
		}
		return "failed to upadte data into db";
	}

}
