package Capston_DB;


import java.sql.*;

public class matchInfoDAO {
		//test code
		public String SearchMatching(String user_id) {
			String SQL1 = "select match_number, creater_id, match_title, match_sex from match_info order by match_number desc";
			
			String matchlist = "";
			try {
			    //DB 연결 
				Connection conn = Capston_Connection.GetDB();
				PreparedStatement ptstn = conn.prepareStatement(SQL1);
				ResultSet rs = ptstn.executeQuery();
				
				while(rs.next()) {
					// 매칭번호, 생성자 이름, 제목, 성별 담기
					matchlist += rs.getInt(1) +":"+ rs.getString(2) +","+ rs.getString(3) +","+ rs.getString(4);
					matchlist += "/";
				}
				
				
				ptstn.close();
				    
				return matchlist;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return "검색실패";
			}
		}
		
		
		public String MyMatching(String user_id) {
			String SQL1 = "select match_number, creater_id, match_title, match_sex "
					+ "from match_info.match_number = match_member.match_number"
					+ " where match_member.user_id = " + user_id;
			
			String matchlist = "";
			try {
			    //DB 연결 
				Connection conn = Capston_Connection.GetDB();
				PreparedStatement ptstn = conn.prepareStatement(SQL1);
				ResultSet rs = ptstn.executeQuery();
				
				while(rs.next()) {
					// 매칭번호, 생성자 이름, 제목, 성별 담기
					matchlist += rs.getInt(1) +":"+ rs.getString(2) +","+ rs.getString(3) +","+ rs.getString(4);
					matchlist += "/";
				}
				
				
				ptstn.close();
				    
				return matchlist;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return "검색실패";
			}
		}
}

