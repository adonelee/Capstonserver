<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String match_number = request.getParameter("match_number");
String user_id = request.getParameter("user_id");


System.out.println(user_id);

String result;
System.out.println(result);
out.print(result);
%>