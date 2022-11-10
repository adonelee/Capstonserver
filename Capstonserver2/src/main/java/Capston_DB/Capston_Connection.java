package Capston_DB;

import java.sql.*;



public class Capston_Connection {
	
	private static Connection conn = null;
	
	public static Connection GetDB()
	{
		if (conn != null)
		{
			return conn;
		}
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");	
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsmatching", "root", "1234");
			return conn;
		} catch (Exception e)
		{
			System.out.println("커넥션 획득 실패");
		}
		return null;
	}
}