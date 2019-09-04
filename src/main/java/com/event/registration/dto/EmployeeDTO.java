package com.event.registration.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 4855180344487732818L;

	private String mid;
	
	private String name;
	
	private Date joinDate;
	
	private String emailId;
	
	private Map<Integer, EventDTO> registerdevents;
	

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Map<Integer, EventDTO> getRegisterdevents() {
		return registerdevents;
	}

	public void setRegisterdevents(Map<Integer, EventDTO> registerdevents) {
		this.registerdevents = registerdevents;
	}

	
	
}
