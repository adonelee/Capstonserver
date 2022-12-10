<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String myId= request.getParameter("myId");

System.out.println(myId);

int result = new noticeDAO().numberOfMsg(myId);
System.out.println(""+result);
out.print(""+result);
%>