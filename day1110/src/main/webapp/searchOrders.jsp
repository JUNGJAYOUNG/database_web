<%@page import="com.sist.vo.OrderBookCustomerVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.OrderBookCustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="searchOrders.jsp" method="post">
		�����̸��� �Է��ϼ��� ==> <input type="text" name="name">
		<input type="submit" value="�˻�">
	</form>
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("name")!=null){
			String name = request.getParameter("name");
			OrderBookCustomerDAO dao = new OrderBookCustomerDAO();
			ArrayList<OrderBookCustomerVO> list = dao.listOrders(name);
		}
	%>
</body>
</html>