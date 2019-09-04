package com.event.registration.dao;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.registration.dto.EmployeeDTO;
import com.event.registration.entity.Employee;
import com.event.registration.entity.Event;
import com.event.registration.mapper.EmployeeMapper;

@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public String createEmployee(Employee employee) throws SQLException {
		sessionFactory.getCurrentSession().save(employee);
		return "success";
	}

	public boolean deleteEmployee(Employee employee) throws Exception {
		Employee e = new Employee();
		e.setMid(employee.getMid());
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("mid", e.getMid()));
		List<Employee> list = criteria.list();
		session.flush();
		if (list.isEmpty())
			throw new Exception("Employee Details not available ");

		String sql = "delete from EMPLOYEES where MID = " + "'"+employee.getMid()+"'";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		Integer i = sqlQuery.executeUpdate();
		if (i >= 1) {
			return true;
		}
		return false;
	}

	public List<EmployeeDTO> getAllEmployees() throws Exception {

		String hql = "from Employee E";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Employee> result = query.list();
		if (result.isEmpty())
			throw new Exception("No Employee available, please create Employee first");
		List<EmployeeDTO> empDto = EmployeeMapper.getAllEmployees(result);
		return empDto;
	}

	public EmployeeDTO getEmployee(String mid) throws Exception {

		Query query = sessionFactory.getCurrentSession().createQuery("from Employee E where E.mid = :mid");
		query.setParameter("mid", mid);
		List<Employee> list = query.list();
		if (list.isEmpty())
			throw new Exception(
					"No Employee available, please create Employee first, Go back using browser back button ");
		List<EmployeeDTO> empDto = EmployeeMapper.getAllEmployees(list);
		return empDto.get(0);
	}

	public boolean verifyEmployee(String mid) throws Exception {

		Query query = sessionFactory.getCurrentSession().createQuery("from Employee E where E.mid = :mid");
		query.setParameter("mid", mid);
		List<Employee> list = query.list();
		if (list.isEmpty())
			return false;
		else
			return true;
	}

	public EmployeeDTO addEventToEmployee(String mid, Integer eventId) throws Exception {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee E where E.mid = :mid");
		query.setParameter("mid", mid);
		List<Employee> employee = query.list();

		if (employee.isEmpty())
			throw new Exception(
					"Employee Details not available, please create Employee first, Go back using browser back button ");

		if (null != employee && !employee.isEmpty()) {
			Criteria criteria = session.createCriteria(Event.class);
			criteria.add(Restrictions.eq("eventId", eventId));
			List<Event> list = criteria.list();

			if (list.isEmpty())
				throw new Exception(
						"Event Details not available, please create Event first, Go back using browser back button");

			if (null != list && !list.isEmpty()) {
				employee.get(0).getEvents().add(list.get(0));
			}
			session.saveOrUpdate(employee.get(0));
		}

		return EmployeeMapper.getEmployee(employee.get(0));
	}

	public EmployeeDTO removeEventToEmployee(String mid, String evIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee E where E.mid = :mid");
		query.setParameter("mid", mid);
		List<Employee> employee = query.list();

		if (employee.isEmpty())
			throw new Exception("Employee Details not available for given Employee Id");

		if (null != employee && !employee.isEmpty()) {
			Criteria criteria = session.createCriteria(Event.class);
			String[] tempEvent = evIds.split(",");
			Integer[] events = new Integer[tempEvent.length];
			for(int i=0; i<tempEvent.length; i++)
			{
				events[i]= Integer.parseInt(tempEvent[i]);
			}
			if (0 != events.length) {

				criteria.add(Restrictions.in("eventId", events));

				List<Event> list = criteria.list();
				if (list.isEmpty())
					throw new Exception("Event Details not available for given Event Id");
				if (null != list && !list.isEmpty()) {
					employee.get(0).getEvents().removeAll(list);
				}
			} else {

					throw new Exception("No event is available to deregister for this Employee");

			}
			session.saveOrUpdate(employee.get(0));
		}

		return EmployeeMapper.getEmployee(employee.get(0));
	}
}