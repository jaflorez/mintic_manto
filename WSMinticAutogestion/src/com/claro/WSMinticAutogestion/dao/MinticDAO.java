package com.claro.WSMinticAutogestion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de Conexion JDBC el Esquema WSExpertTrack
 * @author Luis Bucheli
 *
 */
public class MinticDAO {
	/**
	 * Metodo de trae la conexion a Base de datos, segun datos de conexion
	 * @return
	 */
	public static Connection getConnection(String jdbcURL,String username,String password) {
		try {
			Connection connection;
			System.out.println("jk:"+jdbcURL);
			System.out.println("usr:"+username);
			System.out.println("pwd:"+password);
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(jdbcURL, username, password);
	        return connection;
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}    

}
