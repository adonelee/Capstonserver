<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

 int match_number = Integer.parseInt(request.getParameter("match_number"));
 System.out.println("미친 영준");
 System.out.println(""+match_number);
 
 
 System.out.println("영준이는 미치겟다.");
 
 
 String result = new matchInformation_myDAO().getParticipantsInformation(match_number);
 System.out.println("asdfasdf" + result);
 out.print(result);
%>