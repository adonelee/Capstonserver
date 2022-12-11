package Capston_DB;

import java.sql.*;

public class noticeDAO {

	//알림 보내기 메소드
	public String insert_notice(String sendId, String recvId, String msg, String send_time) {
		Connection conn;
		int notice_code = 0;
		String SQL1 = "select MAX(notice_code) from notice";
		try {
		    //DB 연결 
			conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ResultSet rs = ptstn.executeQuery();
			
			//매칭번호 
			rs.next();
			notice_code = rs.getInt(1) + 1;
			PreparedStatement ptstm;
			ptstn.close();}
		catch(Exception e) {
			System.out.println("insert_notice error"+e.getMessage());
		}
		
		
		String SQL2 = "INSERT INTO notice VALUES(?, ?, ?, ?, ?, true)";
		try {
			conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL2);
			ptstn.setInt(1, notice_code);
			ptstn.setString(2, sendId);
			ptstn.setString(3, recvId);
			ptstn.setString(4, msg);
			ptstn.setString(5, send_time);
			ptstn.executeUpdate();
			ptstn.close();
			
			return "보내기성공";
		}catch(Exception e) {
			System.out.println("insert_notice error"+e.getMessage());
		}
		
		
		return "보내기실패";
	}
	
	//새로운 메세지 수 호출
	public int numberOfMsg(String myId) {
		String SQL2 = "SELECT count(is_new) "
				+ "from notice "
				+ "where recvId = ? and is_new = true ";
		
		int result_number = 0;
		try {
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL2);
			ptstn.setString(1, myId);
			
			ResultSet rs = ptstn.executeQuery();
			rs.next();
			result_number = rs.getInt(1);
			
			ptstn.close();
			
		}catch(Exception e) {
			System.out.println("count_newtice error"+e.getMessage());
		}
		return result_number;
	}
	
	
	
	//알림 내용 호출
	public String callNotice(String myId) {
		String SQL3 = "SELECT sendId, message, send_time "
				+ "from notice "
				+ "where recvId = ? "
				+ "order by notice_code desc";
		
	    String SQL4 = "update notice set is_new = false where recvId= ?";
		
		String notices="";
		
		try {
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL3);
			ptstn.setString(1, myId);
			
			ResultSet rs = ptstn.executeQuery();
			
			while(rs.next()) {
				notices += rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3);
				notices += "@";
			}
			
			rs.close();
			ptstn.close();
			
			try {
				Connection comm = Capston_Connection.GetDB();
				PreparedStatement ptstv = comm.prepareStatement(SQL4);
				
				
				ptstv.setString(1, myId);
				
			    ptstv.executeUpdate();
			    
			    Statement state = comm.createStatement();
				
			    state.close();
			    ptstv.close();
			}catch(Exception e) {
				System.out.println("update error"+e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("call_notice error"+e.getMessage());
		}
		return notices;
	}
}