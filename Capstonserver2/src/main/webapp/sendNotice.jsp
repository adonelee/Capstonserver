<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String sendId= request.getParameter("sendId");
String recvId = request.getParameter("recvId");
String msg = request.getParameter("message");
String send_time = request.getParameter("send_time");

String result = new noticeDAO().insert_notice(sendId, recvId, msg, send_time);

out.print(result);
%>