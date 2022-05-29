package com.ass.test;

import java.util.List;

import com.ass.entity.TypeQuestion;
import com.ass.entity.enumarate.TypeQuestionName;
import com.ass.repository.TypeQuestionRepository;

public class TypeQuestionTest {
	public static void main(String[] args) {
		TypeQuestionRepository repository = new TypeQuestionRepository();

		System.out.println("***********GET ALL TypeQuestionS***********");

		List<TypeQuestion> TypeQuestions = repository.getAllTypeQuestions();

		for (TypeQuestion TypeQuestion : TypeQuestions) {
			System.out.println(TypeQuestion);
		}

		System.out.println("\n\n***********CREATE TypeQuestion***********");
//
//		TypeQuestion TypeQuestionCreate = new TypeQuestion();
//		TypeQuestionCreate.setName(TypeQuestionName.Easy);
//		repository.createTypeQuestion(TypeQuestionCreate);

	}
}
