<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<from action="empTest.jsp" method = "post">
		직원 이름 입력 : <input type="text" name="ename">
		근무 위치 입력 : <input type="text" name="dloc">
		<input type="submit" value="검색">
	</from>
	
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("ename")!=null){
			String ename = request.getParameter("ename");
			String dloc = request.getParameter("dloc");
			EmpDAO dao = new EmpDAO();
			ArrayList<String> list = dao.getNameSameDept(ename, dloc);
			%>
			<table border="1">
				<tr>
					<td>동일한 부서에 근무하거나 입력한 근무위치에 근무하는 직원들 목록</td>
				</tr>
				<tr>
					<td>직원이름</td>
				</tr>
				
				<% 
					for(String empname: list){
	
				%>
					<tr>
						<td><%=empname %></td>
					</tr>
				<% 
					System.out.println(empname);
				}
				%>			
			</table>
			
		<% 	
		}
	%>

</body>
</html>