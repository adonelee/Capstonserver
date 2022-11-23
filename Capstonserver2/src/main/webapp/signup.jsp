<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String sex = request.getParameter("sex");
String phone = request.getParameter("phone");

System.out.println(id);
System.out.println(pw);
System.out.println(name);
System.out.println(sex);
System.out.println(phone);

String result = new signupDAO().SignUP(id,pw,name,sex,phone);
System.out.println(result);
out.print(result);
%>