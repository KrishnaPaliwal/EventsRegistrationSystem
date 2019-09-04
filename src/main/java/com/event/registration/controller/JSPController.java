package com.event.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")

public class JSPController {

	@Autowired
	EmployeeController empcontroller;

	@Autowired
	EventController eventController;

	@RequestMapping(value = "index")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("jsp/registerevent");

		try {
			ModelAndView empMAV = empcontroller.getAllEmployees();

			modelAndView.addAllObjects(empMAV.getModel());

			ModelAndView eventMAV = eventController.getAllEvents();
			modelAndView.addAllObjects(eventMAV.getModel());
		} catch (Exception e) {
			e.getMessage();
		}
		return modelAndView;
	}

	@RequestMapping(value = "emp")
	public ModelAndView employee() {
		ModelAndView modelAndView = new ModelAndView("jsp/employee");
		return modelAndView;
	}

	@RequestMapping(value = "evnt")
	public ModelAndView event() {
		ModelAndView modelAndView = new ModelAndView("jsp/event");
		return modelAndView;
	}

	@RequestMapping(value = "deregister")
	public ModelAndView deregister() {
		ModelAndView modelAndView = new ModelAndView("jsp/deregisterevent");
		return modelAndView;
	}

	@RequestMapping(value = "employeedetails")
	public ModelAndView employeeDetails(String mid) {
		ModelAndView modelAndView = new ModelAndView("jsp/employeedetail");

		ModelAndView empMAV = empcontroller.getEmployee(mid);
		modelAndView.addAllObjects(empMAV.getModel());

		return modelAndView;
	}

	@RequestMapping(value = "deleteemp")
	public ModelAndView deletEemp() {
		ModelAndView modelAndView = new ModelAndView("jsp/deleteemp");
		return modelAndView;
	}

	@RequestMapping(value = "deleteevent")
	public ModelAndView deletEevent() {
		ModelAndView modelAndView = new ModelAndView("jsp/deleteevent");
		return modelAndView;
	}
}
