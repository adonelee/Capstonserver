package Capston_DB;

import java.sql.*;

public class matchInformationDAO{
	public String getMatchInformation(int match_number) {
		String SQL1 = "select match_number, creater_id, match_title"
				+ " exercise_type, match_type, match_time, recruit_person"
				+ " match_sex, match_major from match_info where match_number = ?";
		
		String matchInformation = "";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			ptstn.setInt(1, match_number);
			
			rs.next(); 
				
			//매칭번호 : 생성자, 매치타이틀, 운동 종류, 매칭 종류, 매칭 시간, 모집 인원, 성별, 학과 
			matchInformation += rs.getInt(1) +":"+ rs.getString(2) +","+ rs.getString(3) +","+ rs.getString(4)
			+","+ rs.getString(5) +","+ rs.getString(6) +","+ rs.getInt(7) +","+ rs.getString(8) +","+ rs.getString(9);
			
			ptstn.close();
			    
			return matchInformation;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
	}
}