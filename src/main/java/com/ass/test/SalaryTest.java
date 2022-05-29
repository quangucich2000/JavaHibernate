package com.ass.test;

import java.util.List;

import com.ass.entity.Salary;
import com.ass.entity.enumarate.SalaryName;
import com.ass.repository.SalaryRepository;

public class SalaryTest {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

		System.out.println("***********GET ALL SALARYS***********");

		List<Salary> Salarys = repository.getAllSalarys();

		for (Salary Salary : Salarys) {
			System.out.println(Salary);
		}

		System.out.println("\n\n***********CREATE SALARY***********");

		Salary SalaryCreate = new Salary();
		SalaryCreate.setName(SalaryName.PM);
		repository.createSalary(SalaryCreate);

	}
}
