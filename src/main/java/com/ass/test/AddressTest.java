package com.ass.test;

import java.util.List;

import com.ass.entity.Address;
import com.ass.repository.AddressRepository;

public class AddressTest {
	public static void main(String[] args) {
		AddressRepository repository = new AddressRepository();

		System.out.println("***********GET ALL***********");

		List<Address> Addresss = repository.getAllAddresses();

		for (Address address : Addresss) {
			System.out.println(address);
		}

		System.out.println("\n\n***********CREATE***********");
	}
}
