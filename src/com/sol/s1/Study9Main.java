package com.sol.s1;

import com.sol.s1.location.LocationDAO;
import com.sol.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.getList();
	}
}
