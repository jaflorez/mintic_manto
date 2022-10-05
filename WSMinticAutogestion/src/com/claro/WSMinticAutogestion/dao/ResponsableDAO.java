package com.claro.WSMinticAutogestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.claro.WSMinticAutogestion.vo.ResponsableVO;

public class ResponsableDAO {
	private Connection connection;
	public ResponsableDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	public List<ResponsableVO> listResponsablesByIdBeneficiario(String id_beneficiario){
		List<ResponsableVO> listaResponsable = new ArrayList<>(); 
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		try {
			if(this.connection.isValid(10)) {
				preparedStatement = this.connection.prepareStatement("select id_responsable,id_beneficiario,name_resp,phone,email from responsable where id_beneficiario = ?");
				preparedStatement.setString(1, id_beneficiario);
				resultSet = preparedStatement.executeQuery();
				ResponsableVO responsableVO = null;
				while(resultSet.next()) {
					responsableVO = new ResponsableVO(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
					listaResponsable.add(responsableVO);
				}
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
				if(!preparedStatement.isClosed()) {
					preparedStatement.close();
				}			
			}
		} catch (Exception e) {
			System.out.println("CentroDigitalDAO listResponsablesByIdBeneficiario"+e.toString());
			
			// TODO: handle exception
		}
		return listaResponsable;
	}
	public void  eliminarResponsableById(String id_responsable){
		PreparedStatement preparedStatement = null;
		try {
			
			String sql = "delete from responsable where id_responsable  = ? ";
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, id_responsable);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("CallSpeedTestDAO Find By Id err: "+e.toString());
		}
	}
	public void  crearResponsable(String nombre,String telefono,String email){
		PreparedStatement preparedStatement = null;
		try {
			String sql = "insert into responsable(name_resp,phone,email) values(?,?,?)";
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, telefono);
			preparedStatement.setString(3, email);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("CallSpeedTestDAO Find By Id err: "+e.toString());
		}
	}
	
	

}
