package com.sist.dao;

import java.sql.*;

import com.sist.vo.BookVO;

public class BookDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.101:1521:XE";
	String user = "c##madang";
	String pwd = "madang";
	//추가할 도서의 정보를 BookVO로 매개변수로 전달받아
	//데이터베이스 테이블 BOOK에 insert를 수행하는 메소드를 정의
	//int를 반환
	public int insertBook(BookVO b) {
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//select문이 아니니까 resultset은 필요x
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement("insert into book values(?,?,?,?)");
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			
			re = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("에외발생:"+e.getMessage());
		}finally {
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
