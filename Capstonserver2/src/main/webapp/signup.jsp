<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String sex = request.getParameter("sex");
String major = request.getParameter("major");
String phone = request.getParameter("phone");

String result = new signupDAO().SignUP(id,pw,name,sex,major,phone);

out.print(result);
%>