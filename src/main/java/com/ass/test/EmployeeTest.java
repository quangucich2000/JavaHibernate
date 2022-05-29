package com.ass.test;

import java.util.List;

import com.ass.entity.Employee;
import com.ass.repository.EmployeeRepository;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();

		System.out.println("***********GET ALL***********");

		List<Employee> employees = repository.getAllEmployees();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("\n\n***********CREATE***********");
	}
}
