package com.project.project.Dto;

import javax.persistence.Column;

public class EmployeeDto {

	private String employeeName;

	private String emailId;

	private Long phoneNumber;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		emailId = emailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EmployeeDto(String employeeName, String emailId, Long phoneNumber) {
		super();
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;

	}

	public EmployeeDto() {
		super();
	}

}
