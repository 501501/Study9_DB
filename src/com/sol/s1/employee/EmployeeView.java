package com.sol.s1.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EmployeeView {
	
	// 전체 출력 view
	public void view(ArrayList<EmployeeDTO> ar) {
		for(int i=0;i<ar.size();i++) {
			this.view(ar.get(i));
			System.out.println("--------------------");
		}
	}
	
	// 하나 출력 view
	public void view(EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO.getEmployee_id());
		System.out.println(employeeDTO.getFirst_name());
		System.out.println(employeeDTO.getLast_name());
		System.out.println(employeeDTO.getEmail());
		System.out.println(employeeDTO.getPhone_number());
		System.out.println(employeeDTO.getHire_date());
		System.out.println(employeeDTO.getJob_id());
		System.out.println(employeeDTO.getSalary());
		System.out.println(employeeDTO.getCommission_pct());
		System.out.println(employeeDTO.getManager_id());
		System.out.println(employeeDTO.getDepartment_id());
	}
	
	// double 출력 view
	public void view(double avg) {
		System.out.println(avg);
	}
	
	// HashMap 출력 view
	public void view(HashMap<Integer, Double> hashMap) {
		Iterator<Integer> it = hashMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			Double value = hashMap.get(key);
			System.out.println(key+ ": "+value);
		}
	}
	
	// Emp_DepartDTO 출력 view
	public void view(Emp_DepartDTO emp_departDTO) {
		System.out.println(emp_departDTO.getLast_name());
		System.out.println(emp_departDTO.getSalary());
		System.out.println(emp_departDTO.getHire_date());
		System.out.println(emp_departDTO.getDepartmentDTO().getDepartment_name());
	}
}
