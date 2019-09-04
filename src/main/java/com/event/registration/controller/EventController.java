package com.event.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.event.registration.dao.EventDao;
import com.event.registration.dto.EventDTO;
import com.event.registration.entity.Event;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	private EventDao eventDao;

	@RequestMapping(value = "/save")
	@ResponseBody
	public ModelAndView createEvent(Integer eventId, String eventTitle, String description) {
		ModelAndView modelAndView = new ModelAndView("jsp/eventcreation");
		try {

			boolean result = eventDao.verifyEvent(eventId);
			if (result) {
				modelAndView.addObject("allreadyexist", "Event Already Exists in database");
				return modelAndView;
			}

			Event event = new Event();
			event.setEventId(eventId);
			event.setEventTitle(eventTitle);
			event.setDescription(description);
			eventDao.persistEvent(event);
			modelAndView.addObject("success", "Event successfully created in database");

		} catch (Exception ex) {
			return modelAndView.addObject("error", ex.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String deleteEvent(Integer eventId) {
		try {

			boolean value = eventDao.deleteEvent(eventId);
			if (value) {
				return "Event succesfully deleted!";
			} else
				return "no record found";
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}

	@RequestMapping(value = "/allevents")
	public ModelAndView getAllEvents() throws Exception {
		ModelAndView modelAndView = new ModelAndView("jsp/allevents");
		try {

			modelAndView.addObject("allevents", eventDao.getAllEvents());
		} catch (Exception ex) {
			modelAndView.addObject("norecord", ex.getMessage());
		}

		return modelAndView;

	}

	@RequestMapping(value = "/eventdetails")
	@ResponseBody
	public EventDTO getEvents(Integer eventId) {
		try {
			return eventDao.getEvent(eventId);
		} catch (Exception ex) {
			return null;
		}
	}

}