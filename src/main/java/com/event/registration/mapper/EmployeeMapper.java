package com.event.registration.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.event.registration.dto.EmployeeDTO;
import com.event.registration.dto.EventDTO;
import com.event.registration.entity.Employee;
import com.event.registration.entity.Event;

public class EmployeeMapper {

	public static EmployeeDTO getEmployee(Employee emp) {
		EmployeeDTO empDto = new EmployeeDTO();
		Set<EventDTO> eventsDTO = new HashSet<EventDTO>();

		empDto.setMid(emp.getMid());
		empDto.setEmailId(emp.getEmailId());
		empDto.setJoinDate(emp.getJoinDate());
		empDto.setName(emp.getName());
		Set<Event> events = emp.getEvents();

		eventsDTO = EventMapper.getAllEvents(events);
		Map<Integer, EventDTO> registerdevents = new TreeMap<Integer, EventDTO>();

		for (EventDTO event : eventsDTO) {
			registerdevents.put(event.getEventId(), event);
		}
		empDto.setRegisterdevents(registerdevents);
		return empDto;

	}

	public static List<EmployeeDTO> getAllEmployees(List<Employee> empList) {

		List<EmployeeDTO> empDtoList = new ArrayList<EmployeeDTO>();
		EmployeeDTO temp = new EmployeeDTO();
		for (Employee emp : empList) {
			empDtoList.add(getEmployee(emp));
		}

		return empDtoList;
	}
}
