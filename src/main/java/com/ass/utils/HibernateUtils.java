package com.ass.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.ass.entity.Department;
import com.ass.entity.Salary;
import com.ass.entity.TypeQuestion;
import com.ass.entity.Account;
import com.ass.entity.Exam;
import com.ass.entity.Position;
import com.ass.entity.Question;
import com.ass.entity.Address;
import com.ass.entity.CategoryQuestion;
import com.ass.entity.Employee;
import com.ass.entity.DetailDepartment;
import com.ass.entity.Group;
import com.ass.entity.GroupAccount;
import com.ass.entity.Manager;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;


	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}


	private HibernateUtils() {
		configure();
	}


	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(GroupAccount.class);
		configuration.addAnnotatedClass(Manager.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Exam.class);
		configuration.addAnnotatedClass(CategoryQuestion.class);
		configuration.addAnnotatedClass(TypeQuestion.class);
		configuration.addAnnotatedClass(Question.class);
	}


	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}


	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
