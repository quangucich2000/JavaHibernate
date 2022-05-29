package com.ass.test;

import java.util.List;

import com.ass.entity.Position;
import com.ass.entity.enumarate.PositionName;
import com.ass.repository.PositionRepository;

public class PositionTest {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> positions = repository.getAllPositions();

		for (Position position : positions) {
			System.out.println(position);
		}

		System.out.println("\n\n***********CREATE POSITION***********");
//
//		Position positionCreate = new Position();
//		positionCreate.setName(PositionName.PM);
//		repository.createPosition(positionCreate);

	}
}
