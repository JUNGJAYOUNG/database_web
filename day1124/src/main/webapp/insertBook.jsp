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
	String sql = "select nvl(max(bookid),0)+1 from book";
	int bookid = 0;
%>
	<h2>도서등록</h2>
	<hr>
	<form action="insertBookOK.jsp" method="post">
		도서번호:<input type="number" name="bookid" value="<%=bookid%>"><br>
		도서명:<input type="text" name="bookname"><br>
		출판사명:<input type="text" name="publisher"><br>
		가격:<input type="number" name="price"><br>
		<input type="submit" value="등록"	>
		<input type="reset" value="취소">
	</form>
</body>
</html>