package Capston_DB;

import java.sql.*;


public class TestDAO {

	public String enter_Member()
	{
		String SQL2 = "insert into user values(\"sungwankim\", \"qwer\", 2001, \"김성완\");";
		
		
		try {
			Connection conn = Capston_Connection.GetDB();
			
			//
			PreparedStatement ptstm = conn.prepareStatement(SQL2);
			
			ptstm.executeUpdate();
		    
		    Statement state = conn.createStatement();
			state.close();
			
			return "성공성공성공";
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
		
		
	}
}
