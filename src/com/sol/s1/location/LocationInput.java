package com.sol.s1.location;

import java.util.Scanner;

public class LocationInput {
	
	public LocationDTO inputId(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.print("Location Id를 입력하세요: ");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		return locationDTO;
	}
	
	public LocationDTO inputAll(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.print("Location Id를 입력하세요: ");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		
		System.out.print("Street Address를 입력하세요: ");
		String street_address = sc.next();
		locationDTO.setStreet_address(street_address);
		
		System.out.print("Postal Code를 입력하세요: ");
		String postal_code = sc.next();
		locationDTO.setPostal_code(postal_code);
		
		System.out.print("City를 입력하세요: ");
		String city = sc.next();
		locationDTO.setCity(city);
		
		System.out.print("State Province를 입력하세요: ");
		String state_province = sc.next();
		locationDTO.setState_province(state_province);
		
		System.out.print("Country Id를 입력하세요: ");
		String country_id = sc.next();
		locationDTO.setCity(city);
		
		return locationDTO;
	}
}
