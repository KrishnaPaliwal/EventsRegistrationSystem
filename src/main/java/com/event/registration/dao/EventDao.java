package com.event.registration.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.event.registration.dto.EventDTO;
import com.event.registration.entity.Employee;
import com.event.registration.entity.Event;
import com.event.registration.mapper.EventMapper;

@Repository
@Transactional
public class EventDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private EmployeeDao employeeDao;

	public void persistEvent(Event event) {

		Session session = sessionFactory.getCurrentSession();
		session.save(event);
	}

	public boolean deleteEvent(Integer eventId) throws Exception {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Event.class);
		criteria.add(Restrictions.eq("eventId", eventId));
		List<Event> list = criteria.list();
		sessionFactory.getCurrentSession().flush();
		if (list.isEmpty())
			throw new Exception("Event Details not available ");

		for (Employee emp : list.get(0).getEmployees()) {
			try {
				employeeDao.removeEventToEmployee(emp.getMid(), eventId.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		persistEvent(list.get(0));
		session.flush();

		String sql = "delete from EVENTS where EVENT_ID =" + eventId;
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		Integer i = sqlQuery.executeUpdate();
		if (i >= 1) {
			return true;
		}
		return false;
	}

	public EventDTO getEvent(Integer eventId) throws Exception {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
		criteria.add(Restrictions.eq("eventId", eventId));
		List<Event> list = criteria.list();
		if (list.isEmpty())
			throw new Exception("No Event available, please create event first, Go back using browser back button ");

		EventDTO empDto = EventMapper.getEvent(list.get(0));

		return empDto;

	}

	public boolean verifyEvent(Integer eventId) throws Exception {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
		criteria.add(Restrictions.eq("eventId", eventId));
		List<Event> list = criteria.list();
		if (list.isEmpty())
			return false;
		else
			return true;

	}

	public Set<EventDTO> getAllEvents() throws Exception {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
		List<Event> list = criteria.list();
		if (list.isEmpty())
			throw new Exception("No Event available, please create event first");
		Set<EventDTO> eventDto = EventMapper.getAllEvents(new HashSet(list));
		return eventDto;
	}

}
