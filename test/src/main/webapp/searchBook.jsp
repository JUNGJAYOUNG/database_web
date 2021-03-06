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
	<form action="searchBook.jsp" method="post">
		출판사명 입력하세요 <input type="text" name="publisher">
		<input type="submit" value="검색">
	</form>
	
	<% 
		request.setCharacterEncoding("euc-kr");	//한글입력을 하려면 별도로 인코딩 반드시 필요!
		if(request.getParameter("publisher")!=null){
			String publisher = request.getParameter("publisher");
			BookDAO dao = new BookDAO();
			ArrayList<BookVO> list = dao.searchBook(publisher);
			%>
			<table>
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
							<td><%=b.getBookid()%></td>
							<td><%=b.getBookname()%></td>
							<td><%=b.getPublisher()%></td>
							<td><%=b.getPrice()%></td>				
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