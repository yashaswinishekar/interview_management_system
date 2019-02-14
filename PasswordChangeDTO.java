package com.xworkz.interviewApp.dto;

import java.io.Serializable;

public class PasswordChangeDTO implements Serializable {

	private String oldPassword;
	private String password;
	private String confirmPassword;

	public PasswordChangeDTO() {
		System.out.println(this.getClass().getSimpleName());
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "PasswordChangeDTO [oldPassword=" + oldPassword + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}

}
