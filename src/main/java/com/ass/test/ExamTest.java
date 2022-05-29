package com.ass.test;

import java.util.List;

import com.ass.entity.Exam;
import com.ass.repository.ExamRepository;

public class ExamTest {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

		System.out.println("***********GET ALL EXAMS***********");

		List<Exam> Exams = repository.getAllExams();

		for (Exam Exam : Exams) {
			System.out.println(Exam);
		}

		System.out.println("\n\n***********CREATE EXAMS***********");

		Exam examCreate = new Exam();
		examCreate.setTitle("Bài thi đầu vào 2");
		examCreate.setDuration((short) 185);

		repository.createExam(examCreate);

	}
}
