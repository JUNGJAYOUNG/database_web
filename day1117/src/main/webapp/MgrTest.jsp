<%@page import="com.sist.vo.MgrVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.MgrDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��� ���� Ȯ��</h2>
	<form action="MgrTest.jsp" method="post">
		�����ڸ�<input type="text" name="mgrname">
		�ٹ�������<input type="text" name="workmonth">
		<input type="submit" value="�˻�">
	</form>
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("mgrname")!=null){
			String mgrname = request.getParameter("mgrname");
			int workmonth = Integer.parseInt(request.getParameter("workmonth"));
			MgrDAO dao = new MgrDAO();
			ArrayList<MgrVO> list = dao.searchList(mgrname,workmonth);
		%>
		<table border="1">
		 <tr>
		 	<td>�����ȣ</td>
		 	<td>�����</td>
		 	<td>�Ի���</td>
		 	<td>����</td>
		 	<td>�ֹι�ȣ</td>		 
		 	<td>���̵�</td>		 
		 </tr>
		 <%
		 	for(MgrVO t:list){
		 		%>
		 		<tr>
				 	<td><%=t.getEno() %></td>
				 	<td><%=t.getEname() %></td>
				 	<td><%=t.getHiredate() %></td>
				 	<td><%=t.getSalary() %></td>
				 	<td><%=t.getJumin() %></td>		 
				 	<td><%=t.getId() %></td>		 
		 		</tr>
		 		<%
		 	}
		}
		 %>
		</table>
</body>
</html>