package com.claro.WSMinticAutogestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.claro.WSMinticAutogestion.vo.SpeedTestVO;
import com.claro.WSMinticAutogestion.json.SpeedTestResult;
import com.claro.WSMinticAutogestion.vo.CentroDigitalVO;
import com.claro.WSMinticAutogestion.vo.CallSpeedTestVO;

public class CallSpeedTestDAO {
	private Connection connection;

	public CallSpeedTestDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	public void Save(CallSpeedTestVO callSpeedTestVO) {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO speed_test_call(usuario,ap_id,workflow_process_id,fecha,estado,fecha_solicitud) VALUES(?,?,?,sysdate(),?,?)";
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, callSpeedTestVO.getUsuario());
			preparedStatement.setString(2, callSpeedTestVO.getAp_id());
			preparedStatement.setString(3, callSpeedTestVO.getWorkflow_process_id());
			preparedStatement.setString(4, callSpeedTestVO.getEstado());
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(callSpeedTestVO.getFecha_solicitud().getTime());
			preparedStatement.setTimestamp(5, sqlDate);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("CallSpeedTestDAO Find By Id err: "+e.toString());
		}
		
		
	}
	public void CancelarSolicitudesVencidas(int segundos ) {
		
		PreparedStatement preparedStatement = null;
		try {
			String sql = "update speed_test_call set estado = 'cancelada' where TIMESTAMPDIFF(SECOND,fecha,sysdate()) > ? and estado='registro'";
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setInt(1, segundos);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("CancelarSolicitudesVencidas err: "+e.toString());
		}
		
		
	}
	public CallSpeedTestVO FindByUserApid(String user_id,String ap_id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		CallSpeedTestVO callSpeedTest = null;
		try {
			if(this.connection.isValid(10)) {
				String sql = "SELECT speed_test_call_id,usuario,ap_id,workflow_process_id,fecha,estado,fecha_solicitud from speed_test_call " 
							 +"where usuario = ? and ap_id = ? and estado = 'registro' " 
							 + "and year(fecha) = year(now()) and month(fecha) = month(now()) and day(fecha) = day(now()) limit 1 ;";
				preparedStatement = this.connection.prepareStatement(sql);
				preparedStatement.setString(1, user_id);
				preparedStatement.setString(2, ap_id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					callSpeedTest = new CallSpeedTestVO(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getTimestamp(7));
				}
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
				if(!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			}
		} catch (Exception e) {
			System.out.println("CallSpeedTestDAO Find By Id err: "+e.toString());
			// TODO: handle exception
		}
		return callSpeedTest;
	}
	public void UpdateCallSpeedTestRegistro(String user_id,String ap_id,String estado) {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "update speed_test_call set estado = ? where usuario=? and ap_id = ? and estado= 'registro' ";
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, estado);
			preparedStatement.setString(2, user_id);
			preparedStatement.setString(3, ap_id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("CallSpeedTestDAO Find By Id err: "+e.toString());
		}
	}
}
