package com.claro.WSMinticAutogestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claro.WSMinticAutogestion.vo.CentroDigitalVO;
import com.claro.WSMinticAutogestion.vo.EquipoVO;
import com.claro.WSMinticAutogestion.vo.ResponsableVO;

public class CentroDigitalDAO {
	private Connection connection;
	public CentroDigitalDAO(Connection connection)  throws SQLException, ClassNotFoundException 
	{
		this.connection = connection;
	}
	public CentroDigitalVO findById(String id_beneficiario) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;

		CentroDigitalVO centroDigitalVO = null;
		if(this.connection.isValid(10)) {
			if(id_beneficiario.length() == 5) {
				preparedStatement = this.connection.prepareStatement("SELECT id_beneficiario,llave,id_mintic,nombre_ct_pob,municipio,departamento,vlan,ip_router,server_data from centro_digital where id_beneficiario = ?");
			}
			else if (id_beneficiario.length() == 9) {
				preparedStatement = this.connection.prepareStatement("SELECT id_beneficiario,llave,id_mintic,nombre_ct_pob,municipio,departamento,vlan,ip_router,server_data from centro_digital where id_mintic = ?");
				
			}
			preparedStatement.setString(1, id_beneficiario);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				centroDigitalVO = new CentroDigitalVO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(6),resultSet.getInt(9));
				centroDigitalVO.setEquipos(this.listEquipoByIdBeneficiario(centroDigitalVO.getId_beneficiario()));
				centroDigitalVO.setResponsables(this.listResponsablesByIdBeneficiario(centroDigitalVO.getId_beneficiario()));
				System.out.println(centroDigitalVO.getResponsables().size());
			} else {
				centroDigitalVO = new CentroDigitalVO();
			}
		}
		return centroDigitalVO;
	}
	public List<EquipoVO> listEquipoByIdBeneficiario(String id_beneficiario) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		List<EquipoVO> listaEquipo = new ArrayList<>(); 
		if(this.connection.isValid(10)) {
			preparedStatement = this.connection.prepareStatement("select id_beneficiario,mac,tipo from equipo where id_beneficiario = ?");
			preparedStatement.setString(1, id_beneficiario);
			resultSet = preparedStatement.executeQuery();
			EquipoVO equipoVO = null;
			while(resultSet.next()) {
				equipoVO = new EquipoVO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
				listaEquipo.add(equipoVO);
			} 
		}
		return listaEquipo;
	}
	public List<ResponsableVO> listResponsablesByIdBeneficiario(String id_beneficiario) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		List<ResponsableVO> listaResponsable = new ArrayList<>(); 
		if(this.connection.isValid(10)) {
			preparedStatement = this.connection.prepareStatement("select id_responsable,id_beneficiario,name_resp,phone,email from responsable where id_beneficiario = ?");
			preparedStatement.setString(1, id_beneficiario);
			resultSet = preparedStatement.executeQuery();
			ResponsableVO responsableVO = null;
			while(resultSet.next()) {
				responsableVO = new ResponsableVO(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
				listaResponsable.add(responsableVO);
			} 
		}
		return listaResponsable;
	}
	
	

}
