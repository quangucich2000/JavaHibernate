package com.ass.test;

import java.util.List;

import com.ass.entity.CategoryQuestion;
import com.ass.entity.Department;
import com.ass.repository.CategoryQuestionRepository;

public class CategoryQuestionTest {
	public static void main(String[] args) {
		CategoryQuestionRepository repository = new CategoryQuestionRepository();

		System.out.println("***********GET ALL CategoryQuestionS***********");

		List<CategoryQuestion> CategoryQuestions = repository.getAllCategoryQuestions();

		for (CategoryQuestion CategoryQuestion : CategoryQuestions) {
			System.out.println(CategoryQuestion);
		}

		System.out.println("\n\n***********CREATE CategoryQuestion***********");

//		CategoryQuestion CategoryQuestionCreate = new CategoryQuestion();
//		CategoryQuestionCreate.setUsername("NguyenVanA");
//		CategoryQuestionCreate.setEmail("NguyenVanA@gmail.com");
//		CategoryQuestionCreate.setFirstName("A");
//		CategoryQuestionCreate.setLastName("Nguyen Van");
//
//		repository.createCategoryQuestion(CategoryQuestionCreate);

	}
}
