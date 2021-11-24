package com.sist.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdersDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.105:1521:XE";
	String user="c##madang";
	String pwd="madang";
	
	public ArrayList<OrdersVO> saleCountList(){
		ArrayList<OrdersVO> list = new ArrayList<OrdersVO>();
		String sql = "select * from today_top3";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new OrdersVO(rs.getString(1),rs.getInt(2)));
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				
			}catch(Exception ex) {
				
			}
		}
		
		
		
		return list;
	}
			
}
