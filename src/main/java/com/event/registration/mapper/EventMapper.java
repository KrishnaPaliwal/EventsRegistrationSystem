package com.event.registration.mapper;

import java.util.HashSet;
import java.util.Set;

import com.event.registration.dto.EventDTO;
import com.event.registration.entity.Event;

public class EventMapper {

	public static EventDTO getEvent(Event event) {
		EventDTO eventDto = new EventDTO();
		eventDto.setEventId(event.getEventId());

		eventDto.setEventTitle(event.getEventTitle());
		eventDto.setDescription(event.getDescription());
		return eventDto;

	}

	public static Set<EventDTO> getAllEvents(Set<Event> eventList) {

		Set<EventDTO> eventDtoList = new HashSet<EventDTO>();
		for (Event event : eventList) {
			eventDtoList.add(getEvent(event));
		}

		return eventDtoList;
	}
}
