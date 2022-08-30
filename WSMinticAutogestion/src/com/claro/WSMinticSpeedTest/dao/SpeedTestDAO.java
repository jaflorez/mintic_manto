package com.claro.WSMinticSpeedTest.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SpeedTestDAO {
	public  Connection getConnection(String urlServer,String username,String password) {
		Connection connection = null;
		try {
			System.out.println(urlServer);
			System.out.println("user:"+username);
			System.out.println("psw:"+password);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(urlServer,username, password);
		} 
		catch (SQLException sqle) {
			System.out.println("SpeedTestDAO");
			System.out.println(sqle.toString());
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return connection;
	}    

}



