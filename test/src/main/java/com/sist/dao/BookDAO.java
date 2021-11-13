package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.Book2VO;
import com.sist.vo.BookVO;

public class BookDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user="c##madang";
	String pwd="madang";
	
	public ArrayList<Book2VO> searchByName(String ename){
		ArrayList<Book2VO> list = new ArrayList<Book2VO>();
		
		String sql = "select bookname "
				+ "from book "
				+ "where bookid not in (select bookid "
				+ "from orders "
				+ "where custid = (select custid "
				+ "from customer "
				+ "where name = ?))";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ename);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Book2VO(rs.getString(1)));
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally{
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
	
	public ArrayList<BookVO> searchBook(int price){
		
		String sql="select * from book where price <= ?";
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, price);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));					
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
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
	
	public ArrayList<BookVO> searchBook(int start, int end){
			
			String sql="select * from book where price between ? and ?";
			ArrayList<BookVO> list = new ArrayList<BookVO>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,pwd);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));					
				}
				
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
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
	
	public ArrayList<BookVO> searchBook(String publisher){
		
		String sql = "select * from book where publisher=? order by price desc";
		
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, publisher);
				
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
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
