package Capston_DB;

import java.sql.*;

public class matchAcceptDAO {

	public String accept_matching(String match_number, String user_id)
	{
		Connection conn;
		String SQL1 = "SELECT MIN(member_code) FROM match_member";
		String SQL2 = "INSERT INTO match_member VALUES(?, ?, ?)";
		int member_code;
		try {
			conn = Capston_Connection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL1);		
			ResultSet rs = ptstn.executeQuery();
			rs.next();
			member_code = rs.getInt(1) + 1;
			ptstn.close();
			
			PreparedStatement ptstm = conn.prepareStatement(SQL2);
			ptstm.setInt(1, member_code);
			ptstm.setInt(2, Integer.parseInt(match_number));
			ptstm.setString(3, user_id);
			ptstm.executeUpdate();
			ptstm.close();
			
			//delete메소드 호출위치
			delete_request(match_number, user_id);
			return "참여성공";				
		}catch (Exception e) {
			System.out.println("aceept에러 :" + e.getMessage());
			return "참여실패";
		}
	}
	
	// match_request에서 삭제
	public void delete_request(String match_number, String user_id) {
		String SQL3 = "DELETE FROM match_request WHERE match_number = ? AND user_id = ?";
		
		try {
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL3);
			ptstn.setInt(1, Integer.parseInt(match_number));
			ptstn.setString(2, user_id);
			ptstn.executeUpdate();
			ptstn.close();
		}catch(Exception e) {
			System.out.println("delete에러 :" + e.getMessage());
		}
	}
}