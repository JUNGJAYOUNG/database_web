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
	<h3>���೻�� ��ȸ</h3>
	<form action="reserveTest.jsp" method="post">
		���̸��� �Է��ϼ���<input type="text" name="name">
		<input type="submit" value="�˻�"	>	
	</form>
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("name")!=null){
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
			
			<%			
		}

	%>

</body>
</html>