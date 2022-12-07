package Capston_DB;

import java.sql.*;

public class matchInformationDAO{
	
	
	
	public String getMatchInformation(int match_number) {
		String matchInformation = "";
		
		String SQL1 = "select match_number, creater_id, match_title,"
				+ " exercise_type, match_type, match_time, recruit_person,"
				+ " match_sex, match_major from match_info where match_number = ?";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			
			
			ptstn.setInt(1, match_number);
			
			ResultSet rs = ptstn.executeQuery();
			
			rs.next(); 
				
			//매칭번호 : 생성자, 매치타이틀, 운동 종류, 매칭 종류, 매칭 시간, 모집 인원, 성별, 학과 
			matchInformation += rs.getInt(1) +":"+ rs.getString(2) +","+ rs.getString(3) +","+ rs.getString(4)
			+","+ rs.getString(5) +","+ rs.getString(6) +","+ rs.getInt(7) +","+ rs.getString(8) +","+ rs.getString(9).toString();
			
			ptstn.close();
			    
			return matchInformation;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
	}
	
	
	
	
	
	
	
	
	public String getParticipantsInformation(int match_number) {
		String ParticipantsInformation = "";
		String[] ParticipantsInfo;
		String PI = "";
		
		String SQL1 = "select user_id from match_member where match_number = ?";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			
			
			ptstn.setInt(1, match_number);
			
			ResultSet rs = ptstn.executeQuery();
					
			while(rs.next()) {
				ParticipantsInformation += rs.getString(1);
				ParticipantsInformation += "/";
			}
			rs.close();
			ptstn.close();
			    
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
		try {
			Connection conn = Capston_Connection.GetDB();
			
			ParticipantsInfo = ParticipantsInformation.split("/");
			int num = ParticipantsInfo.length;
			
			
			for(int i=0; i<num; i++) {
				String SQL2 = "select user_name, user_phone, user_major from user where user_id = ?";
				PreparedStatement ptstm = conn.prepareStatement(SQL2);
				ptstm.setString(1, ParticipantsInfo[i]);
				ResultSet rd = ptstm.executeQuery();
				rd.next();
				PI += rd.getString(1) + "," + rd.getString(2) + "," + rd.getString(3);
				PI += "/";
				
				ptstm.close();
				rd.close();
				}
			
			return PI;			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
	}
}
 
