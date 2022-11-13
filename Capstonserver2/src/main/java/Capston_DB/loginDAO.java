package Capston_DB;

import java.sql.*;

public class loginDAO {

	public String login(String userID, String userPW)
	{
		
		String SQL1 = "SELECT user_id, user_pw FROM user WHERE user_id = ? AND user_pw = ?";
		
		try {
			Connection conn = Capston_Connection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ptstn.setString(1, userID);
			ptstn.setString(2, userPW);
			
			ResultSet rs = ptstn.executeQuery();
			
			if(rs.next()) {
				ptstn.close();
				return "로그인성공";
			}else {
				ptstn.close();
				return "로그인실패";
			}
			
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
	}
}