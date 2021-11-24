package com.sist.dao;

import java.sql.*;
import java.util.ArrayList;

import com.sist.vo.MgrVO;

public class MgrDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	private String user="c##madang";
	private String pwd="madang";
	
	
	public ArrayList<MgrVO> searchList(String mgrname, int workmonth){
		ArrayList<MgrVO> list = new ArrayList<MgrVO>();
		
		String sql = "select e.eno, e.ename, e.hiredate, e.salary, rpad(substr(e.jumin,1,7),14,'*') jumin, substr(e.email,1,instr(e.email,'@')-1) id "
				+ "from emp e, emp m "
				+ "where e.mgr =  m.eno and "
				+ "m.ename = ? and "
				+ "months_between(sysdate,e.hiredate) >= ?";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mgrname);
			pstmt.setInt(2,workmonth);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MgrVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
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
