<%@page import="com.sist.dao.CustomerDAO"%>
<%@page import="com.sist.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insertCustomer.jsp" method="post">
		고객번호:<input type="text" name="custid"><br>
		고객이름:<input type="text" name="name"><br>
		주소:<input type="text" name="address"><br>
		전화번호:<input type="text" name="phone"><br>
		<input type="submit" value="등록">
	</form>
	<% 
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("custid")!=null){
			int custid = Integer.parseInt(request.getParameter("custid"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			
			CustomerVO c = new CustomerVO(custid,name,address,phone);
			
			CustomerDAO dao = new CustomerDAO();
			
			int re=dao.insertCustomer(c);
		
			if(re==1){
				%>
				고객등록에 성공하였습니다.
				<%
			}else{
				%>
				고객등록에 실패하였습니다.
				<%
			}
		}
	%>
	
</body>
</html>