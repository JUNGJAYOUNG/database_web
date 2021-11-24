<%@page import="com.sist.exam.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.exam.BookList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>도서목록</h2>
<%
	BookList blist = new BookList();
	ArrayList<BookVO> list = blist.booklist();
	for(BookVO b:list){
%>	
	<table border="1">
	<tr>
	<td><%=b.getBookid() %></td>
	<td><a href="detailbook.jsp?no=<%=b.getBookid()%>"><%=b.getBookname() %></a></td>
	</tr>
	</table>
	<%
	}
	%>
</body>
</html>