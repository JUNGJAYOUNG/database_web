package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user = "c##madang";
	String pwd = "madang";
	
	//������ �̸��� �ٹ���ġ�� �Է¹޾� ������ �μ��� �ٹ��ϰų� �Է��� �ٹ���ġ�� �ٹ��ϴ� ������ �̸� ���
	public ArrayList<String> getNameSameDept(String ename, String dloc){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select ename "
				+ "from emp "
				+ "where dno = (select dno "
				+ "from emp "
				+ "where ename = ?) or dno in (select dno "
				+ "from dept "
				+ "where dloc = ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(url);
			pstmt.setString(1, ename);
			pstmt.setString(2, dloc);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new String(rs.getString(1)));
			}

		}catch(Exception e) {
			
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn  != null) {
					conn.close();
				}
			}catch(Exception ex) {
				
			}
		}
		return list;
	}
	
	
	
	
	
	
}