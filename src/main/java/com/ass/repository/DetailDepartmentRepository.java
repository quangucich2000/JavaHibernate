package com.ass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ass.entity.DetailDepartment;
import com.ass.utils.HibernateUtils;

public class DetailDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DetailDepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<DetailDepartment> getAllDetailDepartments() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(DetailDepartment department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
