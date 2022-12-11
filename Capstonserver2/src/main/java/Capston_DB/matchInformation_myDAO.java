package Capston_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class matchInformation_myDAO {
	String ParticipantsInformation = "";
	String[] ParticipantsInfo;
	String PI = "";
public String getParticipantsInformation(int match_number) {
		
		
		String SQL1 = "select user_id from match_member where match_number = ?";
		System.out.println("testtesttest = " + match_number);
		try {
		    //DB 연결 
			Connection conn = Capston_Connection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			
			
			ptstn.setInt(1, match_number);
			
			ResultSet rs = ptstn.executeQuery();
					
			while(rs.next()) {
				ParticipantsInformation += rs.getString(1);
				ParticipantsInformation += "/";
			}
			System.out.println(ParticipantsInformation);
			rs.close();
			ptstn.close();
			    
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
		try {
			Connection conn = Capston_Connection.GetDB();
			
			ParticipantsInfo = ParticipantsInformation.split("/");
			int num = ParticipantsInfo.length;
			
			
			for(int i=0; i<num; i++) {
				String SQL2 = "select user_name, user_phone, user_major from user where user_id = ?";
				PreparedStatement ptstm = conn.prepareStatement(SQL2);
				ptstm.setString(1, ParticipantsInfo[i]);
				ResultSet rd = ptstm.executeQuery();
				rd.next();
				PI += rd.getString(1) + "," + rd.getString(2) + "," + rd.getString(3);
				PI += "/";
				
				
				ptstm.close();
				
				}
			System.out.println(PI);
			return PI;			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "검색실패";
		}
	}
}
