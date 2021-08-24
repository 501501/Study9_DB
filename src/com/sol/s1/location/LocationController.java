package com.sol.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		locationInput = new LocationInput();
		sc = new Scanner(System.in);
	}
	
	public void start() {
		
		boolean check = true;
		
		while(check) {
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 하나의 정보 출력");
			System.out.println("3. 지역 정보 추가");
			System.out.println("4. 지역 정보 삭제");
			System.out.println("5. 나가기");
			
			
			int select = sc.nextInt();
			
			if (select == 1) {
				ArrayList<LocationDTO> ar = locationDAO.getList();
				if (ar.size() > 0) {
					locationView.view(ar);
				} else {
					locationView.view("데이터가 없습니다");
				}
				
			} else if (select == 2) {
				LocationDTO locationDTO = locationInput.inputId(sc);
				locationDTO = locationDAO.getOne(locationDTO);
				if (locationDTO != null) {
					locationView.view(locationDTO);
				} else {
					locationView.view("해당 Location Id가 없습니다");
				}
				
			} else if (select == 3) {
				LocationDTO locationDTO = locationInput.inputAll(sc);
				int result = locationDAO.setLocation(locationDTO);
				if (result > 0) {
					locationView.view("삽입 성공");
				} else {
					locationView.view("삽입 실패");
				}
				
			} else if (select == 4) {
				LocationDTO locationDTO = locationInput.inputId(sc);
				int result = locationDAO.delLocation(locationDTO);
				if (result > 0) {
					locationView.view("삭제 성공");
				} else {
					locationView.view("삭제 실패");
				}
			} else {
				check = false;
			}
		}
	}
}
