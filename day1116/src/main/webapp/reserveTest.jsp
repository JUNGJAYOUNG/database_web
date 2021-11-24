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
	<h3>예약내역 조회</h3>
	<form action="reserveTest.jsp" method="post">
		고객이름을 입력하세요<input type="text" name="name">
		<input type="submit" value="검색"	>	
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
			 	<td>극장이름</td>
			 	<td>상영관번호</td>
			 	<td>영화이름</td>
			 	<td>예약일</td>
			 	<td>좌석번호</td>		 
			 	<td>가격</td>		 
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