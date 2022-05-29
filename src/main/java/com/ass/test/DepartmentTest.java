package com.ass.test;

import java.util.List;

import com.ass.dto.DepartmentDto;
import com.ass.entity.Address;
import com.ass.entity.Department;
import com.ass.entity.DetailDepartment;
import com.ass.repository.AddressRepository;
import com.ass.repository.DepartmentRepository;
import com.ass.repository.DetailDepartmentRepository;

public class DepartmentTest {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();
		AddressRepository addressRepository = new AddressRepository();

//		System.out.println("***********GET ALL***********");
//		
//		List<DepartmentDto> departmentDtos = repository.getAllDepartments();
//		
//		for (DepartmentDto departmentDto : departmentDtos) {
//			System.out.println(departmentDto);
//		}
		
//		System.out.println("***********GET ALL Short by name***********");
//		
//		List<DepartmentDto> departmentDtos = repository.getAllDepartments(1);
//		
//		for (DepartmentDto departmentDto : departmentDtos) {
//			System.out.println(departmentDto);
//		}
		
//		System.out.println("***********GET ALL Paging***********");
//		int page = 1;
//		int pageSize = 3;
//		List<DepartmentDto> departmentDtos = repository.getAllDepartments(page, pageSize);
//		
//		for (DepartmentDto departmentDto : departmentDtos) {
//			System.out.println(departmentDto);
//		}
		
		System.out.println("***********GET ALL Search***********");
		List<DepartmentDto> departmentDtos = repository.getAllDepartments("gi");
		
		for (DepartmentDto departmentDto : departmentDtos) {
			System.out.println(departmentDto);
		}

//		System.out.println("\n\n***********CREATE***********");
//
//		Department department = new Department();
//		department.setName("Phong so tuyen");	
//		
//		repository.createDepartment(department);

	}
}
