<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*"%>
<%
 request.setCharacterEncoding("UTF-8");

String creater_id = request.getParamerter("creater_id");

System.out.println(creater_id);

String matchNum = new authorityDAO().findMatchNum(creater_id);

//매칭이 2개이상 나오면 해결하기 위한 함
if(matchNum.contains("/")){
	
}

String userId = new authorityDAO().authorityInfo(Integer.parseInt(matchNum));

String userInfo = new authorityDAO().authorityUserInfo(userId);

System.out.println(userInfo);
out.println(userInfo);

%>