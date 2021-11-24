<%@page import="java.sql.*"%>
<%@page import="com.sist.db.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>도서번호</td>
		<td>도서명</td>
		<td>출판사</td>
		<td>가격</td>
	</tr>
<%
	String sql = "select bookid, bookname, publisher, price from book order by bookid";
	try{
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
		%>
		<tr>
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getInt(4) %></td>
		</tr>
		<%
		}
		ConnectionProvider.close(conn,pstmt,rs);
	}catch(Exception e){
		%>
		예외발생:<%=e.getMessage() %>
		<%
	}
%>
</table>
<hr>
<a href="insertBook.jsp">도서등록</a>

</body>
</html>