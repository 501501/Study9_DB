package com.sol.s1.employee;

import java.util.Scanner;

public class EmployeeController {
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		int select = 0;
		
		while(true) {
			System.out.println("1. 전체 사원 출력");
			System.out.println("2. 사원 번호 검색");
			System.out.println("3. Last_name 검색");
			System.out.println("4. First_name 검색");
			System.out.println("5. 전체 평균 급여 정보 출력");
			System.out.println("6. 부서별 평균 급여 정보 출력");
			System.out.println("7. 사원의 id로 사원의 이름, 급여, 입사일, 부서명 출력");
			
			select = sc.nextInt();
			
			// 1. 전체 사원 출력
			if (select == 1) {
				employeeView.view(employeeDAO.getList());
			} 
			
			// 2. 사원 번호를 입력해서 한 사원의 정보 출력
			else if (select == 2) {
				System.out.print("사원의 번호를 입력하세요: ");
				int employee_id = sc.nextInt();
				employeeView.view(employeeDAO.getOne(employee_id));
			}
			
			// 3. Last_name을 검색해서 정보 출력
			else if(select == 3) {
				System.out.print("Last_name을 입력하세요: ");
				String last_name = sc.next();
				employeeView.view(employeeDAO.getSearchLastName(last_name));
			}
			
			// 4. First_name을 검색해서 정보 출력
			else if (select == 4) {
				System.out.print("First_name을 입력하세요: ");
				String first_name = sc.next();
				employeeView.view(employeeDAO.getSearchFirstName(first_name));
			}
			
			// 5. 전체 평균 급여 정보를 출력
			else if (select == 5) {
				employeeView.view(employeeDAO.getAverage());
			}
			
			// 6. 부서별 평균 급여의 정보를 출력
			else if (select == 6) {
				employeeView.view(employeeDAO.getDeptAverage());
			}
			
			// 7. join
			else if (select == 7) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(101);
				employeeView.view(employeeDAO.getJoin(employeeDTO));
			}
			
			else {
				break;
			}
		}
	}
}