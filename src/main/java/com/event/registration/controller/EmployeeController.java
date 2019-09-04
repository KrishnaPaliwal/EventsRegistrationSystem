package com.event.registration.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.event.registration.dao.EmployeeDao;
import com.event.registration.dto.EmployeeDTO;
import com.event.registration.entity.Employee;
import com.event.registration.utility.EventUtility;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/save")
	public ModelAndView createEmployee(String mid, String name, String joinDate, String emailId) {
		ModelAndView modelAndView = new ModelAndView("jsp/employeecreation");
		try {
			boolean result = employeeDao.verifyEmployee(mid);
			if (result) {
				modelAndView.addObject("allreadyexist", "Employee Already Exists in database");
				return modelAndView;
			}
			Employee employee = new Employee();
			employee.setName(name);
			employee.setMid(mid);
			employee.setJoinDate(EventUtility.convetToDate(joinDate));
			employee.setEmailId(emailId);

			employeeDao.createEmployee(employee);
			modelAndView.addObject("success", "Employee successfully created in database");

		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String deleteEmployee(String mid) {
		try {
			Employee employee = new Employee();
			employee.setMid(mid);
			boolean value = employeeDao.deleteEmployee(employee);
			if (value) {
				return "Employee succesfully deleted!";
			} else
				return "no record found";
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}

	@RequestMapping(value = "/allemployees")
	public ModelAndView getAllEmployees() throws Exception {
		ModelAndView modelAndView = new ModelAndView("jsp/allemployees");

		try {
			modelAndView.addObject("allemployees", employeeDao.getAllEmployees());

		} catch (Exception ex) {
			modelAndView.addObject("norecord", ex.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "/employeedetails")
	@ResponseBody
	public ModelAndView getEmployee(String mid) {
		try {
			EmployeeDTO result = employeeDao.getEmployee(mid);
			ModelAndView modelAndView = new ModelAndView("jsp/employeedetails");
			modelAndView.addObject("employee", employeeDao.getEmployee(mid));
			return modelAndView;
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/assignevent")
	@ResponseBody
	public ModelAndView addEventToEmployee(@RequestParam("employeeId") String mid, @RequestParam("eventId") String evId)
			throws SQLException {
		ModelAndView modelAndView = new ModelAndView("jsp/employeedetails");
		Integer eventId = Integer.parseInt(evId);
		try {

			EmployeeDTO employee = employeeDao.addEventToEmployee(mid, eventId);
			modelAndView.addObject("employee", employee);
			modelAndView.addObject("success", "Event is registered to Employee succussfully !!!");
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/deleteregistedevent")
	@ResponseBody
	public ModelAndView removeEventToEmployee(@RequestParam("employeeId") String mid,
			@RequestParam("eventId") String evIds) throws SQLException {
		ModelAndView modelAndView = new ModelAndView("jsp/employeedetails");

		try {
			EmployeeDTO employee = employeeDao.removeEventToEmployee(mid, evIds);
			modelAndView.addObject("employee", employee);
			modelAndView.addObject("success", "Event is de-registerd succussfully !!!");
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
		}
		return modelAndView;
	}

}