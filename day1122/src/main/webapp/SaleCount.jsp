<%@page import="com.sist.vo.OrdersVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.OrdersDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>오늘의 TOP3</h2>
	<table border="1">
		<tr>
			<td>책이름</td>
			<td>총판매수량</td>
		</tr>
	<%
		OrdersDAO dao = new OrdersDAO(); 
		ArrayList<OrdersVO> list = dao.saleCountList();
		for(OrdersVO o : list){
	%>	
		<tr>
			<td><%=o.getBookname() %></td>
			<td><%=o.getCnt() %></td>	
		</tr>
	<%
		}
	%>		
		</table>
</body>
</html>