package com.ass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ass.entity.TypeQuestion;
import com.ass.utils.HibernateUtils;

public class TypeQuestionRepository {

	private HibernateUtils hibernateUtils;

	public TypeQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<TypeQuestion> getAllTypeQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createTypeQuestion(TypeQuestion TypeQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(TypeQuestion);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
