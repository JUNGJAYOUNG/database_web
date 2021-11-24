<%@page import="java.sql.*"%>
<%@page import="com.sist.db.ConnectionProvider"%>
<%@page import="org.apache.catalina.filters.ExpiresFilter.XServletOutputStream"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<ul>

<%
	String sql = "select * from customer order by custid";
	
	try{
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			%>
				<li><a href="updateAddr.jsp?custid=<%=rs.getInt(1)%>"><%=rs.getString(2) %></a></li>			
			<%
		}
		ConnectionProvider.close(conn,pstmt,rs);
	}catch(Exception e){
		System.out.println("예외발생:"+e.getMessage());		
	}

%>
</ul>
</body>
</html>