package com.sol.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	public Connection getConnection() throws Exception {
		String user = "user01";
		String password = "user01";

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("접속 성공");
//		System.out.println(con);		
		return con;
	}
	
	public void disconnect(ResultSet rs, PreparedStatement st, Connection con) {
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
