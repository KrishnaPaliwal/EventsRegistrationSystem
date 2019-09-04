package com.event.registration.dto;

import java.io.Serializable;

public class EventDTO implements Serializable {

	private static final long serialVersionUID = 4579145490769020561L;

	private Integer eventId;
	
	private String eventTitle;
	
	private String description;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
