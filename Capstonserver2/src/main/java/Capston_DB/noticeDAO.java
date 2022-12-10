package Capston_DB;

import java.sql.*;

public class noticeDAO {

	//알림 보내기 메소드
	public String insert_notice(String sendId, String recvId, String msg, String send_time) {
		Connection conn;
		String SQL1= "INSERT INTO notice VALUES(?, ?, ?, ?)";
		try {
			conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ptstn.setString(1, sendId);
			ptstn.setString(2, recvId);
			ptstn.setString(3, msg);
			ptstn.setString(4, send_time);
			ptstn.executeUpdate();
			ptstn.close();
			
			return "보내기성공";
		}catch(Exception e) {
			System.out.println("insert_notice error"+e.getMessage());
		}
		
		
		return "보내기실패";
	}
	
	
	//새로운 메세지 수 호출
	public int numberOfMsg(String myId, String call_time) {
		String SQL2 = "SELECT count(message) "
				+ "from notice "
				+ "where myId = ? and send_time > ? ";
		int result_number = 0;
		
		return result_number;
	}
	
	//알림 내용 호출
	public String callNotice() {
		String notices="";
		
		return notices;
	}
}