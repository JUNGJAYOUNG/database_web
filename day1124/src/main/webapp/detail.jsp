<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <h2>������</h2>
 <hr>
 <table>
	<%
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookDAO dao = new BookDAO();
		BookVO b = dao.getBook(bookid);

	%>
	<tr><td>������ȣ</td><td><td><%=b.getBookid() %></td></tr> 
	<tr><td>������</td><td><td><%=b.getBookname() %></td></tr> 
	<tr><td>���ǻ��</td><td><td><%=b.getPublisher() %></td></tr> 
	<tr><td>��������</td><td><td><%=b.getPrice() %></td></tr>
	 
</table>
</body>
</html>