package com.ass.test;

import java.util.List;

import com.ass.entity.Group;
import com.ass.repository.GroupRepository;

public class GroupTest {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		System.out.println("***********GET ALL***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
		}
	}
}
