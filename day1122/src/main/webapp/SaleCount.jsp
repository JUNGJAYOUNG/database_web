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
	<h2>������ TOP3</h2>
	<table border="1">
		<tr>
			<td>å�̸�</td>
			<td>���Ǹż���</td>
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