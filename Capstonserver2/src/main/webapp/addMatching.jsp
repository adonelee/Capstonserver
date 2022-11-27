<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String match_owner = request.getParameter("match_owner");
String match_title = request.getParameter("match_title");
int exercise_type = Integer.parseInt(request.getParameter("exercise_type"));
int match_type = Integer.parseInt(request.getParameter("match_type"));
String match_time = request.getParameter("match_time");
int match_persons = Integer.parseInt(request.getParameter("match_persons"));
String match_sex = request.getParameter("match_sex");
String match_major = request.getParameter("match_major");

System.out.println(match_title);

String result = new addMatchingDAO().AddMatching(match_owner, match_title, exercise_type,
		match_type, match_time, match_persons, match_sex, match_major);
System.out.println(result);
out.print(result);
%>