package Capston_DB;

import java.sql.*;

public class authorityDAO {
    //생성자 아이디로 만들어진 매칭번호 찾기 
	public String findMatchNum(String creater_id){
		String SQL1 = "select match_number from match_info where creater_id = ?";
		
		String MatchNum = "";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			ptstn.setString(1, creater_id);
			
			//매칭을 두개이상 만들 수 있으므로 반복문으로 처리  
			while(rs.next()) {
				// 10000/10001 이런식으로 쌓일거 예
				MatchNum += rs.getInt(1);
				MatchNum += "/";
			}
			
			
			ptstn.close();
			    
			return MatchNum;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
	}
	
	//매칭번호로 가입 리퀘스트에 있는 user_id 찾기 
	public String authorityInfo(int match_number) {
		String SQL1 = "select user_id from match_request where match_number = ?";
		
		
	    String user_id ="";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			ptstn.setInt(1, match_number);
			
			rs.next(); 
			
			user_id += rs.getString(1);
			
			ptstn.close();
		    
			return user_id;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
			}
		}
	
	//찾은 유저 아이디로 정보 추출 이름,학과,전화번
	public String authorityUserInfo(String user_id) {
		String SQL1 = "select user_name, user_major, user_phone from user where user_id = ?";
		
		String UserInfo = "";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			ptstn.setString(1, user_id);
			
			rs.next(); 
			
			UserInfo += rs.getString(1) +","+ rs.getString(2) +","+ rs.getString(3);
			
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
