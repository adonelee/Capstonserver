package Capston_DB;


import java.sql.*;

public class matchApplyDAO{
	public String Apply(String match_number , String user_id) {
		String SQL1 = "insert into match_request values(?,?)";
		
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			
			
			ptstn.setInt(1, Integer.parseInt(match_number));
			ptstn.setString(2, user_id);
			
		    ptstn.executeUpdate();
		    
		    Statement state = conn.createStatement();
			
		    state.close();
		    ptstn.close();
			
		    return "참가신청성공";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "참가신청실패";
		}
	}
}