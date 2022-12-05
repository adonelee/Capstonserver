package Capston_DB;

import java.sql.*;

public class authorityDAO {
    //생성자 아이디로 만들어진 매칭번호 찾기 
	public String[] findUserId(String creater_id){
		String SQL1 = "select match_number from match_info where creater_id = ?";
		
		String[] matchNums1 = null;
		String[] userIds = null;
		String matchNums2 = "";
	
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			ptstn.setString(1, creater_id);
			
			//매칭을 두개이상 만들 수 있으므로 반복문으로 처리  
			while(rs.next()) {
				matchNums2 += rs.getInt(1);
				matchNums2 += "/";
			}
			
			//split 함수로 몇개의 값이 들어왔는지 확인 
			int i = matchNums2.split(matchNums2, '/').length;
			//들어온 매칭넘버 수 만큼 배열 생성 
			matchNums1 = new String[i];
			userIds = new String[i];
			
			matchNums1 = matchNums2.split("/");
			
			
			for(String num : matchNums1) {
				String SQL2 = "select user_id from match_request where match_number = ?";
				
				try {
				    //DB 연결 
					Connection conn1 = Capston_Connection.GetDB();
					PreparedStatement ptstm = conn1.prepareStatement(SQL2);
					ResultSet rs1 = ptstm.executeQuery();
					
					ptstm.setString(1, num);
					
					rs1.next(); 
					//유저아이디 저장하는데에 배열로 저장 
					userIds[i] = num + "&" + rs.getString(1);
					//한 사이클 돌면 i증
					i++;
					
					ptstn.close();
				    
					return userIds;
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
					return userIds;
					}
			}
			ptstn.close();	    
			return userIds;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return userIds;
		}
	}
	
	
	//배열로 넘어온 유저 정보를 찾
	public String authorityUserInfo(String[] user_ids) {
		String SQL1 = "select user_id, user_name, user_major, user_phone from user where user_id = ?";
		
		//넘어온 배열의 길이 확인 
		int num = user_ids.length;
		String UserInfo = "";
		int i;
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			for(i=0;i<num;i++) {
				String[] infos = user_ids[i].split("&");
				ptstn.setString(1, infos[1]);
				rs.next(); 
				UserInfo += infos[0]+","+rs.getString(1) +","+rs.getString(2) +","+ rs.getString(3) +","+ rs.getString(4);
				UserInfo += "/";
			}
			ptstn.close();
		    
			return UserInfo;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
			}
	}
}

/* 혹시 모르는 조인문 남겨두겠습니다.
String SQL1 = "select user.user_name, user.user_major, user.user_phone "
		+ "FROM user "
		+ "JOIN match_request "
		+ "ON user.user_id = match_request.user_id ";
*/
