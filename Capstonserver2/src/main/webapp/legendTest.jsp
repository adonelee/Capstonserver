<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String str = request.getParameter("yMSG");
	System.out.println(str);
	if(str != null){
		out.print("jsp성공");
	}else{
		out.print("jsp실패");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testtestlegend</title>
</head>
<body>
<h2> HELLO YEONGJUN </h2>
<h1><%=str %></h1>
</body>

</html>