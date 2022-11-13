<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	System.out.println(id);
	System.out.println(pw);
	
	String result = new loginDAO().login(id,pw);
	
	out.print(result);
%>