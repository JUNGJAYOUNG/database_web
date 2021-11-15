package com.sist.dao;

import java.sql.*;

import com.sist.vo.CustomerVO;

public class CustomerDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.101:1521:XE";
	String user = "c##madang";
	String pwd = "madang";
	
	public int insertCustomer(CustomerVO c) {
	
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into customer values(?,?,?,?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,c.getCustid());
			pstmt.setString(2,c.getName());
			pstmt.setString(3,c.getAddress());
			pstmt.setString(4,c.getPhone());
	
			re=pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally{
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception ex) {
				
			}
		}
		return re;	
	}
	
	
}
