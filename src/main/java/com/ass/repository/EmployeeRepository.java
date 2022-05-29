package com.ass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ass.entity.Employee;
import com.ass.utils.HibernateUtils;

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;

	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Employee> query = session.createQuery("FROM Employee");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Employee employee) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(employee);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
