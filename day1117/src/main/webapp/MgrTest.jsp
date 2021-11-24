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
<h2>사원 정보 확인</h2>
	<form action="MgrTest.jsp" method="post">
		관리자명<input type="text" name="mgrname">
		근무개월수<input type="text" name="workmonth">
		<input type="submit" value="검색">
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
		 	<td>사원번호</td>
		 	<td>사원명</td>
		 	<td>입사일</td>
		 	<td>연봉</td>
		 	<td>주민번호</td>		 
		 	<td>아이디</td>		 
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