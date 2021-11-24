package com.sist.exam;
import java.sql.*;
import java.util.ArrayList;


public class BookList {
	Connection conn;
	public BookList() {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@192.168.219.105:1521:XE";
		String user="c##madang";
		String pwd="madang";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("데이터베이스 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<BookVO> booklist() {
		String sql = "select * from book";
		Statement stmt=null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		}catch(Exception e) {
			
		}finally {
			try {
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
				if(rs != null)
					rs.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return list;
	}
	
	public void sqlRun() {
		String query = "select * from book";
		Statement stmt=null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			System.out.println("BOOK NO\t BOOK NAME \tPUBLISHER \tPRICE");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3)+"\t");
				System.out.println(rs.getInt(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
				if(rs != null)
					rs.close();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BookList so = new BookList();
		so.sqlRun();
	}
}
