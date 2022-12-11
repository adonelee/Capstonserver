<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String match_number = request.getParameter("match_number");

String user_id = request.getParameter("member_id");

String result = new matchRefuseDAO().delete_request(match_number, user_id);

out.print(result);
%>