package com.sol.s1;

import com.sol.s1.employee.EmployeeController;
import com.sol.s1.location.LocationController;
import com.sol.s1.location.LocationDAO;
import com.sol.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
//		LocationController locationController = new LocationController();
//		locationController.start();
		
		EmployeeController employeeController = new EmployeeController();
		employeeController.start();
	}
}
