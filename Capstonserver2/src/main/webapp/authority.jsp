<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

 String creater_id = request.getParameter("creater_id");
 
 System.out.println(creater_id);
 
 String[] user_Ids = new authorityDAO().findUserId(creater_id);
 
 String result = new authorityDAO().authorityUserInfo(user_Ids);
 
 System.out.println(result);
 
 out.print(result);

%>