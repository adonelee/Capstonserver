<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="Capston_DB.*" import="java.util.HashMap";%>
<%
 request.setCharacterEncoding("UTF-8");

String creater_id = request.getParamerter("creater_id");

System.out.println(creater_id);

String matchNum = new authorityDAO().findMatchNum(creater_id);

//매칭이 2개이상 나오면 해결하기 위한 함
if(matchNum.contains("/")){
	
}


HashMap<int> match_number = new HashMap<int>();
match_number.put("");

Stirng result;
for(int num : match_number){
	SQL1="";
			putInt(1, num);
			result += 
}


String userId = new authorityDAO().authorityInfo(Integer.parseInt(matchNum));

String userInfo = new authorityDAO().authorityUserInfo(userId);

System.out.println(userInfo);
out.println(userInfo);

%>