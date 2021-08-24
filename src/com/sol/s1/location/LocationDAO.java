package com.sol.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sol.s1.util.DBConnect;

public class LocationDAO {
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	// List
	public ArrayList<LocationDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				ar.add(locationDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disconnect(rs, st, con);
		}
		return ar;
	}
	
	// One
	public LocationDTO getOne(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO result = null;
		
		try {
			con = dbConnect.getConnection();
			
			//db 연결 확인
			//System.out.println(con);
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new LocationDTO();
				result.setLocation_id(rs.getInt("location_id"));
				result.setStreet_address(rs.getString("street_address"));
				result.setPostal_code(rs.getString("postal_code"));
				result.setCity(rs.getString("city"));
				result.setState_province(rs.getString("state_province"));
				result.setCountry_id(rs.getString("country_id"));
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disconnect(rs, st, con);
		}
		return result;
	}
	
	// 지역 정보 추가
	public int setLocation(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = dbConnect.getConnection();
			String sql = "INSERT INTO LOCATIONS VALUES (?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			st.setString(2, locationDTO.getStreet_address());
			st.setString(3, locationDTO.getPostal_code());
			st.setString(4, locationDTO.getCity());
			st.setString(5, locationDTO.getState_province());
			st.setString(6, locationDTO.getCountry_id());
			result = st.executeUpdate();
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
		}
		return result;
	}
	
	// 지역 정보 삭제
	public int delLocation(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = dbConnect.getConnection();
			String sql = "DELETE FROM LOCATIONS WHERE LOCATION_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			result = st.executeUpdate();
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
		}
		return result;
	}
}
