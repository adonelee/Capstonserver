package Capston_DB;


import java.sql.*;

public class createrDAO {
		//test code
		public String SearchCreater(String match_number) {
			String SQL1 = "select creater_id from match_info where match_number = ?";
			
			String creater_id = "";
			
			try {
			    //DB 연결 
				Connection conn = Capston_Connection.GetDB();
				PreparedStatement ptstn = conn.prepareStatement(SQL1);
				
				ptstn.setString(1, match_number);
				
				ResultSet rs = ptstn.executeQuery();
				
				rs.next();
				
				creater_id = rs.getString(1);
		
				rs.close();
				ptstn.close();

				return creater_id;
				    
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return "검색실패";
			}
		}
}