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
	public  Connection getConnection(String jdbcURL,String username,String password) {
		try {
			Connection connection;
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(jdbcURL, username, password);
	        return connection;
		} 
		catch (SQLException sqle) {
			System.out.println("MinticDAO MinticDAO SQLException ");
			System.out.println(sqle.toString());
			sqle.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.out.println("MinticDAO ClassNotFoundException");
			System.out.println(e.toString());
			e.printStackTrace();
		} 
		return null;
	}    

}
