package Capston_DB;

import java.sql.*;

public class signupDAO {
		//test code
		public String SignUP(String id, String pw, String name, String sex, String phone) {
			String SQL1 = "select * from user where user_id = ?";
			String SQL2 = "insert into user values(?,?,?,?,?)";
			
			try {
			    //DB 연결 
				Connection conn = Capston_Connection.GetDB();
				PreparedStatement ptstn = conn.prepareStatement(SQL1);
				ptstn.setString(1, id);
				ResultSet rs = ptstn.executeQuery();
				
				if(rs.next()) {
					ptstn.close();
					return "중복";
				}
				else {
				    try {
				    	ptstn.close();
				    	PreparedStatement ptstm = conn.prepareStatement(SQL2);
						
						ptstm.setString(1, id);
						ptstm.setString(2, pw);
						ptstm.setString(3, name);
						ptstm.setString(4, sex);
						ptstm.setString(5, phone);
					    ptstm.executeUpdate();
					    
					    Statement state = conn.createStatement();
						
					    state.close();
					    ptstm.close();
						
					    return "성공";
				    }catch (Exception e){
						System.out.println(e.getMessage());
						return "삽입실패";
				     }		    
		         }
			 }catch(Exception e) {
				System.out.println(e.getMessage());
				return "검색실패";
				}
			}
}
