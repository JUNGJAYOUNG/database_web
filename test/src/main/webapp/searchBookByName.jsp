<%@page import="com.sist.vo.Book2VO"%>
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
	<form action="searchBookByName.jsp" method="post">
		�������� �Է��ϼ��� <input type="text" name="ename">
		<input type="submit" value="�˻�">
	</form>
	
	<% 
		request.setCharacterEncoding("euc-kr");	//�ѱ��Է��� �Ϸ��� ������ ���ڵ� �ݵ�� �ʿ�!
		if(request.getParameter("ename")!=null){
			String ename = request.getParameter("ename");
			BookDAO dao = new BookDAO();
			ArrayList<Book2VO> list = dao.searchByName(ename);
			%>
			<table border="1">
				<tr>
					<td>������</td>			
				</tr>
				<%
					for(Book2VO b:list){
						%>
						<tr>
							<td><%=b.getEname()%></td>			
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