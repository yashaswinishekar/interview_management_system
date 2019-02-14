package com.xworkz.interviewApp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidatetab")
public class CandidateDTO implements Serializable {
	public CandidateDTO() {
		System.out.println(this.getClass().getSimpleName());
	}

	private String user;
	private String password;
	private boolean newUser;
	private String name;
	private String email;
	@Id
	private long mobileNumber;
	private Date dob;
	private String location;
	private String gender;
	private String jobCode;
	private String experiance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getExperiance() {
		return experiance;
	}

	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getNewUser() {
		return newUser;
	}

	public boolean setNewUser(boolean newUser) {
		return this.newUser = newUser;
	}

	@Override
	public String toString() {
		return "CandidateDTO [user=" + user + ", password=" + password + ", newUser=" + newUser + ", name=" + name
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", dob=" + dob + ", location=" + location
				+ ", gender=" + gender + ", jobCode=" + jobCode + ", experiance=" + experiance + "]";
	}

}
