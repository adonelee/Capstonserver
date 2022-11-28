package Capston_DB;

import java.sql.*;

public class addMatchingDAO {
		//test code
		public String AddMatching(String match_owner, String match_title, String exercise_type, 
				String match_type, String match_time, int match_persons, String match_sex, String match_major) {
			String SQL1 = "select MAX(match_number) from match_info";
			String SQL2 = "insert into match_info values(?,?,?,?,?,?,?,?,?)";
			String SQL3 = "select MAX(match_number) from match_member";
			String SQL4 = "insert into match_member values(?,?,?)";
			
			try {
			    //DB 연결 
				Connection conn = Capston_Connection.GetDB();
				PreparedStatement ptstn = conn.prepareStatement(SQL1);
				ResultSet rs = ptstn.executeQuery();
				
				//매칭번호 
				int match_number = rs.getInt(1) + 1;
				
				ptstn.close();
				    try {
				    	
				    	PreparedStatement ptstm = conn.prepareStatement(SQL2);
						
						ptstm.setInt(1, match_number);
						ptstm.setString(2, match_owner);
						ptstm.setString(3, match_title);
						ptstm.setString(4, exercise_type);
						ptstm.setString(5, match_type);
						ptstm.setString(6, match_time);
						ptstm.setInt(7, match_persons);
						ptstm.setString(8, match_sex);
						ptstm.setString(9,  match_major);
						
					    ptstm.executeUpdate();
					    
					    Statement state = conn.createStatement();
						
					    state.close();
					    ptstm.close();
						
					    try {
					    	PreparedStatement ptstx = conn.prepareStatement(SQL3);
							ResultSet ra = ptstx.executeQuery();
							
							int member_code = ra.getInt(1) + 1;
							
							ptstx.close();
							
							try {
								PreparedStatement ptstv = conn.prepareStatement(SQL4);		
								ptstv.setInt(1, member_code);
							    ptstv.setInt(2, match_number);
							    ptstv.setString(3, match_owner);
							
							    ptstv.executeUpdate();
		
							    ptstv.close();
							    
						    }catch(Exception e){
						    	System.out.println(e.getMessage());
								return "삽입실패";
							
						     }
							return "삽입성공";
						
					    }catch (Exception e){
							System.out.println(e.getMessage());
							return "검색실패";
						}
				    
				    }catch(Exception e) {
				    	System.out.println(e.getMessage());
				    	return "삽입실패";	    
				    }
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return "검색실패";
			}
		}	
}

