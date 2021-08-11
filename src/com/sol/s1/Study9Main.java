package com.sol.s1;

import com.sol.s1.department.Depart_EmpDTO;
import com.sol.s1.department.DepartmentDAO;
import com.sol.s1.department.DepartmentDTO;
import com.sol.s1.employee.EmployeeController;
import com.sol.s1.location.LocationController;
import com.sol.s1.location.LocationDAO;
import com.sol.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
//		LocationController locationController = new LocationController();
//		locationController.start();
		
//		EmployeeController employeeController = new EmployeeController();
//		employeeController.start();
		
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(100);
		
		Depart_EmpDTO dto = dao.getJoin(departmentDTO);
		
		for(int i=0; i<dto.getAr().size();i++) {
			System.out.println(dto.getAr().get(i).getLast_name());
			System.out.println(dto.getAr().get(i).getSalary());
			System.out.println(dto.getAr().get(i).getHire_date());
			System.out.println(dto.getDepartment_name());
			System.out.println("-----------------------");
		}
	}
}
