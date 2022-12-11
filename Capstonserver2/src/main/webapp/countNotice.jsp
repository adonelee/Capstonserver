<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String myId= request.getParameter("myId");

int result = new noticeDAO().numberOfMsg(myId);

out.print(""+result);
%>