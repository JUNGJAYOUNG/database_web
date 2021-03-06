package com.sist.dao;
import java.util.ArrayList;

import com.sist.vo.DeptEmpVO;

import java.sql.*;

public class DeptEmpDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user="c##madang";
	String pwd="madang";
	
	public ArrayList<DeptEmpVO> searchList(String dloc){
		ArrayList<DeptEmpVO> list = new ArrayList<DeptEmpVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select eno, ename, comm, salary+comm, d.dno, dname "
				+ "from dept d, emp e "
				+ "where d.dno = e.dno and "
				+ "dloc = ?"
				+ "order by dname, ename";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dloc);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new DeptEmpVO(rs.getInt(1),
						rs.getString(2),rs.getInt(3),rs.getInt(4)
						,rs.getInt(5),rs.getInt(6),rs.getString(7)));	
			}
		}catch(Exception e) {
			System.out.println("???ܹ߻?:"+e.getMessage());
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
		return list;
	}
	
}
