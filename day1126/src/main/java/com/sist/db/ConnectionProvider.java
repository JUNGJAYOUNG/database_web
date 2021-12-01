package com.sist.db;


import java.sql.*;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
			String user="c##olym";
			String pwd="olym";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}catch(Exception e) {
			
		}
	}
	
}
