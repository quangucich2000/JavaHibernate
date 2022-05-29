package com.ass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ass.dto.DepartmentDto;
import com.ass.entity.Department;
import com.ass.entity.DetailDepartment;
import com.ass.utils.HibernateUtils;

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllDepartments(String name) {

		Session session = null;
		
		try {

			// get session
			session = hibernateUtils.openSession();
			Query<DepartmentDto> queryHql;

			// create hql query
			if(name == null) {
				queryHql = session.createQuery("select new com.ass.dto.DepartmentDto(d.id, d.name, d.address.name)" 
						  + " FROM DetailDepartment d");
			}
			else {
				queryHql = session.createQuery("select new com.ass.dto.DepartmentDto(d.id, d.name, d.address.name)" 
						  + " FROM DetailDepartment d"
						  + " where d.name LIKE '%"+ name +"%'");
			}
			
			return (List<T>) queryHql.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllDepartments(int shortId) {

		Session session = null;
		
		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DepartmentDto> queryHql = session.createQuery("select new com.ass.dto.DepartmentDto(d.id, d.name, d.address.name)" 
					  + " FROM DetailDepartment d"
					  + " order by name DESC");
			
			return (List<T>) queryHql.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllDepartments(int pageNumber, int pageSize) {

		Session session = null;
		
		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query queryHql = session.createQuery("select new com.ass.dto.DepartmentDto(d.id, d.name, d.address.name)" 
					  + " FROM DetailDepartment d");
			queryHql.setFirstResult(pageNumber-1);
			queryHql.setMaxResults(pageSize);
			
			return (List<T>) queryHql.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

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

	public void updateDepartment(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(short id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
