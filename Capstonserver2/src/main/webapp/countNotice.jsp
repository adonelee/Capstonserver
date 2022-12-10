<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String myId= request.getParameter("myId");
String call_time = request.getParameter("call_time");

System.out.println(myId + "&&" + call_time);

String result = new noticeDAO().insert_notice(sendId, recvId, msg, send_time);
System.out.println(result);
out.print(result);
%>