package com.ass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ass.entity.Question;
import com.ass.utils.HibernateUtils;

public class QuestionRepository {

	private HibernateUtils hibernateUtils;

	public QuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createQuestion(Question Question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Question);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
