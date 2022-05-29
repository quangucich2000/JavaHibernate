package com.ass.test;

import java.util.List;

import com.ass.entity.Question;
import com.ass.repository.QuestionRepository;

public class QuestionTest {
	public static void main(String[] args) {
		QuestionRepository repository = new QuestionRepository();

		System.out.println("***********GET ALL***********");

		List<Question> Questions = repository.getAllQuestions();

		for (Question Question : Questions) {
			System.out.println(Question);
		}
	}
}
