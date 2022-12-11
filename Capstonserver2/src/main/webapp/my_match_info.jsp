<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String user_id = request.getParameter("user_id");

String result = new matchInfoDAO().MyMatching(user_id);

out.print(result);
%>