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
import com.xworkz.interviewApp.dto.PasswordChangeDTO;
import com.xworkz.interviewApp.service.PasswordChangeService;

@Repository
public class PasswordChangeDAO {
	 private static final Logger slf4jLogger=LoggerFactory.getLogger(PasswordChangeDAO.class);

	@Autowired
	private SessionFactory factory;
	private Session session;

	public PasswordChangeDAO() {
		slf4jLogger.info(this.getClass().getSimpleName());
	}

	public CandidateDTO fetchDTO(PasswordChangeDTO dto) {
		CandidateDTO dtoFromDb = null;
		try (Session session = factory.openSession()) {
			String syntax = "select cdto from CandidateDTO cdto where cdto.password=:changePassword";
			Query query = session.createQuery(syntax);
			if (dto != null) {
				query.setParameter("changePassword", dto.getOldPassword());
				// query.executeUpdate();
				dtoFromDb = (CandidateDTO) query.uniqueResult();
				return dtoFromDb;
			} else {
				slf4jLogger.info("dto object not found");
			}
		} catch (Exception e) {
			slf4jLogger.info("failed to get the data from the database");
		}
		return dtoFromDb;
	}

	public String updateDTO(PasswordChangeDTO dto) {
		CandidateDTO dtoFromDb = null;
		try {
			String syntax = "update  CandidateDTO cdto set cdto.password=:newPassword  where cdto.password=:oldPassword";
			session = factory.openSession();
			Query query = session.createQuery(syntax);
			if (dto != null) {
				query.setParameter("newPassword", dto.getPassword());
				query.setParameter("oldPassword", dto.getOldPassword());
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
		return "failed to update data into db";
	}

}
