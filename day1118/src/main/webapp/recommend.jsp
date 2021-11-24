<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="recommend.jsp" method="post">
	고객이름<input type="text" name="name">
	<input type="submit" value="검색">
</form>
	<% 
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("name")!= null){
			String name=request.getParameter("name");
			BookDAO dao = new BookDAO();
			ArrayList<BookVO> list = dao.listBook(name);
		%>
			<table border="1">
				<tr>
					<td>도서번호</td>
					<td>도서명</td>
					<td>출판사명</td>
					<td>가격</td>
				</tr>
		<% 
			for(BookVO b:list){
				%>
				<tr>
					<td><%=b.getBookid() %></td>
					<td><%=b.getBookname() %></td>
					<td><%=b.getPublisher() %></td>
					<td><%=b.getPrice() %></td>
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