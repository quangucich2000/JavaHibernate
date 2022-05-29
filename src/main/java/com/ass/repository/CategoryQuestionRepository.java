package com.ass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ass.entity.CategoryQuestion;
import com.ass.utils.HibernateUtils;

public class CategoryQuestionRepository {

	private HibernateUtils hibernateUtils;

	public CategoryQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<CategoryQuestion> getAllCategoryQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createCategoryQuestion(CategoryQuestion CategoryQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(CategoryQuestion);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
