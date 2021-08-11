package com.sol.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sol.s1.department.DepartmentDTO;
import com.sol.s1.util.DBConnect;

public class EmployeeDAO {
	// DB 직접 연결
	private DBConnect dbConnect;
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}
	
	// getJoin
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO dto = null;
		
		try {
			con = dbConnect.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT LAST_NAME, SALARY, HIRE_DATE, DEPARTMENT_NAME");
			sb.append(" FROM EMPLOYEES E INNER JOIN DEPARTMENTS D");
			sb.append(" ON E.DEPARTMENT_ID = D.DEPARTMENT_ID");
			sb.append(" WHERE E.EMPLOYEE_ID = ?");
			
//			String sql = "SELECT LAST_NAME, SALARY, HIRE_DATE, DEPARTMENT_NAME "
//					+ "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D "
//					+ "ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
//					+ "WHERE E.EMPLOYEE_ID = 101";
			
			st = con.prepareStatement(sb.toString());
			st.setInt(1, employeeDTO.getEmployee_id());
			rs = st.executeQuery();
			
			if (rs.next()) {
				dto = new Emp_DepartDTO();
				dto.setDepartmentDTO(new DepartmentDTO());
				dto.setLast_name(rs.getString(1));
				dto.setSalary(rs.getInt(2));
				dto.setHire_date(rs.getDate(3));
			
				// department_name
				dto.getDepartmentDTO().setDepartment_name(rs.getString(4));
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

	// 1. 전체 사원 출력
	public ArrayList<EmployeeDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT * FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();	
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("SALARY"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				ar.add(employeeDTO);
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
		return ar;
	}
	
	// 2. 사원 번호를 입력해서 한 사원의 정보 출력
	public EmployeeDTO getOne(int employee_id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1,employee_id);
			rs = st.executeQuery();	
			
			if(rs.next()) {
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));			
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
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
		return employeeDTO;
	}
	
	// 3. Last_name을 검색해서 정보 출력
	public ArrayList<EmployeeDTO> getSearchLastName(String last_name) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1,"%"+last_name+"%");
			rs = st.executeQuery();	
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("SALARY"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				ar.add(employeeDTO);
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
		return ar;
	}
	
	// 4. First_name을 검색해서 정보 출력
	public ArrayList<EmployeeDTO> getSearchFirstName(String first_name) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1,"%"+first_name+"%");
			rs = st.executeQuery();	
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("SALARY"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				ar.add(employeeDTO);
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
		return ar;
	}
	
	// 5. 전체 평균 급여 정보를 출력
	public double getAverage() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double avg = 0;
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();	
			rs.next();
			avg = rs.getDouble(1);
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
		return avg;
	}
	
	// 6. 부서별 평균 급여의 정보를 출력
	public HashMap<Integer, Double> getDeptAverage() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		HashMap<Integer, Double> hashMap = new HashMap<>();
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT DEPARTMENT_ID, AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();	
			while(rs.next()) {
				hashMap.put(rs.getInt("DEPARTMENT_ID"),rs.getDouble("AVG(SALARY)"));
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
		return hashMap;
	}
}
