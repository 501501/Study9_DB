package com.sol.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sol.s1.employee.EmployeeDTO;
import com.sol.s1.util.DBConnect;

public class DepartmentDAO {
	private DBConnect dbConnect;
	
	public DepartmentDAO() {
		dbConnect = new DBConnect();
	}
	
	// insert 
	public int setInsert(DepartmentDTO departmentDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = dbConnect.getConnection();
			String sql = "INSERT INTO DEPARTMENTS VALUES (?, ?, ?, ?)";
			st= con.prepareStatement(sql);
			st.setInt(1, departmentDTO.getDepartment_id());
			st.setString(2, departmentDTO.getDepartment_name());
			st.setInt(3, departmentDTO.getManager_id());
			st.setInt(4, departmentDTO.getLocation_id());
			result = st.executeUpdate(); //insert, update, delete
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} return result;
	}
	
	// getJoin()
	public Depart_EmpDTO getJoin(DepartmentDTO departmentDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO dto = null;
		
		try {
			con = dbConnect.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME ");
			sb.append("FROM EMPLOYEES E INNER JOIN DEPARTMENTS D ");
			sb.append("USING (DEPARTMENT_ID) ");
			sb.append("WHERE DEPARTMENT_ID = ?");
			
			st = con.prepareStatement(sb.toString());
			st.setInt(1, departmentDTO.getDepartment_id());
			
			rs = st.executeQuery();
			
			dto = new Depart_EmpDTO();
			dto.setAr(new ArrayList<EmployeeDTO>());
			
			while(rs.next()) {
				EmployeeDTO eDTO = new EmployeeDTO();
				eDTO.setLast_name(rs.getString(1));
				eDTO.setSalary(rs.getInt(2));
				eDTO.setHire_date(rs.getDate(3));
				dto.getAr().add(eDTO);
				dto.setDepartment_name(rs.getString(4));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}
}
