package Capston_DB;

import java.sql.*;

public class loginDAO {

	public String login(String userID, String userPW)
	{
		
		String SQL1 = "SELECT * FROM user WHERE user_id = ? AND user_pw = ?";
		
		try {
			Connection conn = Capston_Connection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ptstn.setString(1, userID);
			ptstn.setString(2, userPW);
			
			ResultSet rs = ptstn.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("user_id");
				String name = rs.getString("user_name");
				String sex = rs.getString("user_sex");
				String major = rs.getString("user_major");
				String phone = rs.getString("user_phone");
				
				String result = "로그인성공"+ "," + id+ "," + name+ "," + sex +","+ major+","+ phone;
				ptstn.close();
				return result;
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