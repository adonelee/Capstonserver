package Capston_DB;

import java.sql.*;

public class addMatchingDAO {
		//test code
		public String AddMatching(String match_owner, String match_title, int exercise_type, 
				int match_type, String match_time, int match_persons, String match_sex) {
			String SQL1 = "select MIN(match_number) from match_info";
			String SQL2 = "insert into match_info values(?,?,?,?,?,?,?,?)";
			
			try {
			    //DB 연결 
				Connection conn = Capston_Connection.GetDB();
				PreparedStatement ptstn = conn.prepareStatement(SQL1);
				ResultSet rs = ptstn.executeQuery();
				
				int match_number = rs.getInt(0) + 1;
				ptstn.close();
				    try {
				    	
				    	PreparedStatement ptstm = conn.prepareStatement(SQL2);
						
						ptstm.setInt(1, match_number);
						ptstm.setString(2, match_owner);
						ptstm.setString(3, match_title);
						ptstm.setInt(4, exercise_type);
						ptstm.setInt(5, match_type);
						ptstm.setString(6, match_time);
						ptstm.setInt(7, match_persons);
						ptstm.setString(8, match_sex);
						
					    ptstm.executeUpdate();
					    
					    Statement state = conn.createStatement();
						
					    state.close();
					    ptstm.close();
						
					    return "성공";
				    }catch (Exception e){
						System.out.println(e.getMessage());
						return "삽입실패";
				     }		    
		         
			 }catch(Exception e) {
				System.out.println(e.getMessage());
				return "검색실패";
				}
			}
}
