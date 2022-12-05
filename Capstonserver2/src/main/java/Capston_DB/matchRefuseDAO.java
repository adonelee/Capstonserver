package Capston_DB;

import java.sql.*;

public class matchRefuseDAO {

	// match_request에서 삭제
	public void delete_request(String match_number, String user_id) {
		String SQL3 = "DELETE FROM match_request WHERE match_number = ? AND user_id = ?";
		
		try {
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL3);
			ptstn.setInt(1, Integer.parseInt(match_number));
			ptstn.setString(2, user_id);
			ptstn.executeQuery();
			ptstn.close();
		}catch(Exception e) {
			System.out.println("delete에러 :" + e.getMessage());
		}
	}
}