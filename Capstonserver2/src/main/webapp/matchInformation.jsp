<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
request.setCharacterEncoding("UTF-8");

int match_number = request.getParameter("match_number");

System.out.println(match_number);

String result = new matchInformationDAO().getMatchInformation(match_number);

out.print(result);
%>