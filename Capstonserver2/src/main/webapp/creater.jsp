<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
request.setCharacterEncoding("UTF-8");

String match_number = request.getParameter("match_number");

System.out.println(match_number);

String result = new createrDAO().SearchCreater(match_number);
System.out.println(result);
out.print(result);
%>