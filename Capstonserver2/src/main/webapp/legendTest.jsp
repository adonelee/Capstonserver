<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<% 

	request.setCharacterEncoding("UTF-8");

	String str = request.getParameter("yMSG");

	if(str != null){
		out.print("jsp성공");
	}else{
		out.print("jsp실패");
	}
%>