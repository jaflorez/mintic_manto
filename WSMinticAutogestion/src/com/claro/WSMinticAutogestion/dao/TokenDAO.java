package com.claro.WSMinticAutogestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.claro.WSMinticAutogestion.vo.TokenVO;

public class TokenDAO extends MinticDAO {
	private Connection connection;
	public TokenDAO(Connection connection)  throws SQLException, ClassNotFoundException {
		this.connection = connection;
	}
	
	public TokenVO consultar_token() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		TokenVO tokenVO = null;
		try {
			if(this.connection.isValid(10)) {
				preparedStatement = this.connection.prepareStatement("SELECT token_access_point_srv1,token_access_point_srv2,token_router_switch_srv1,fecha FROM token limit 1;");
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					tokenVO = new TokenVO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4));
				}
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
				if(!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			}
			else {
				System.err.println("Error en la conexion");
				
			}
		} catch (Exception e) {
			System.out.println("ConsultarTokenDAO "+e.toString());
		}
		return tokenVO;
	}
	public void update(TokenVO tokenVO) {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE token SET token_access_point_srv1 = ?, token_access_point_srv2 = ?, token_router_switch_srv1 = ?, fecha = ?;";
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, tokenVO.getToken_access_point_srv1());
			preparedStatement.setString(2, tokenVO.getToken_access_point_srv2());
			preparedStatement.setString(3, tokenVO.getToken_router_switch_srv1());
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(tokenVO.getFecha().getTime());
			preparedStatement.setTimestamp(4, sqlDate);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("CallSpeedTestDAO Find By Id err: "+e.toString());
		}

		
	}
	
	

}
