package com.sist.dao;

import java.util.ArrayList;
import java.sql.*;
import com.sist.vo.OrderBookCustomerVO;

public class OrderBookCustomerDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user="c##madang";
	String pwd="madang";
	
	
	public int getTotalSalePrice(String name) {
		int total = 0;
		
		String sql = "select sum(saleprice) from customer c, orders o "
				+ "where c.custid=o.custid and name=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
				
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception ex) {
				
			}
		}
		return total;
	}
	
	
	public ArrayList <OrderBookCustomerVO> listOrders(String name){
		ArrayList<OrderBookCustomerVO> list = new ArrayList<OrderBookCustomerVO>();
		
		String sql = "select c.custid, name, bookname, publisher, price, saleprice, orderdate "
				+ "from orders o,customer c, book b "
				+ "where o.custid = c.custid and "
				+ "b.bookid = o.bookid and "
				+ "name=? "
				+ "order by price desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new OrderBookCustomerVO(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getDate(7)));
			}
			
		}catch(Exception e) {
			System.out.println("???ܹ߻?:"+e.getMessage());
		}finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
				if(rs!=null)
					rs.close();
			}catch(Exception ex) {
				
			}
		}
	
		return list;
	}
	
	
	
	
	
}
