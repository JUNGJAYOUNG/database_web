package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.ReserveVO;

public class ReserveDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@192.168.219.101:1521:XE";
	private String user="c##sist";
	private String pwd="sist";
	
	
	public ArrayList<ReserveVO> getReserveByName(String name){
		ArrayList<ReserveVO> list = new ArrayList<ReserveVO>();
		
		String sql = "select 극장이름, 상영관.상영관번호, 영화제목, 날짜, 좌석번호, 가격 "
				+ "from 극장,상영관,예약,고객 "
				+ "where 극장.극장번호=상영관.극장번호 and "
				+ "상영관.극장번호=예약.극장번호 and "
				+ "상영관.상영관번호=예약.상영관번호 and "
				+ "예약.고객번호 = 고객.고객번호 and "
				+ "이름=?";
		
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
				list.add(new ReserveVO(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getInt(6)));
			}
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(Exception ex) {
				
			}
		}
		
		return list;
	}
	
}
