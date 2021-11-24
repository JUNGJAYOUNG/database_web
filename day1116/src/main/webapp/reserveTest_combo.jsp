<%@page import="com.sist.dao.CustomerDAO"%>
<%@page import="com.sist.vo.CustomerVO"%>
<%@page import="com.sist.vo.ReserveVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.ReserveDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		CustomerDAO customerDAO = new CustomerDAO();
		ArrayList<CustomerVO> customerList = customerDAO.listCustomer();
		request.setCharacterEncoding("euc-kr");
		
		
	%>
	<h3>���೻�� ��ȸ</h3>
	<form action="reserveTest_combo.jsp" method="post">
		���̸�<select name="name">
			<% 
			 for(CustomerVO c: customerList){
				%>
				<option value="<%=c.getName()%>"><%=c.getName()%></option>
				<%	
			 }
		
			%>
		</select>
		<br>
		<input type="submit" value="�˻�"	>	
	</form>
	<%
			String name = request.getParameter("name");
			ReserveDAO dao = new ReserveDAO();
			ArrayList<ReserveVO> list=dao.getReserveByName(name);
		
			%>
			<table border="1">
			<tr>
			 	<td>�����̸�</td>
			 	<td>�󿵰���ȣ</td>
			 	<td>��ȭ�̸�</td>
			 	<td>������</td>
			 	<td>�¼���ȣ</td>		 
			 	<td>����</td>		 
		 	</tr>
			<%
			for(ReserveVO r : list){
			%>
					<tr>
						<td><%=r.getTheaterName()%></td>
						<td><%=r.getCinemaNo()%></td>
						<td><%=r.getTitle()%></td>
						<td><%=r.getDate()%></td>
						<td><%=r.getSeatNo()%></td>
						<td><%=r.getPrice()%></td>
					</tr>
				<% 
			}
			%>
			</table>


</body>
</html>