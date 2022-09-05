package com.claro.WSMinticSpeedTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.claro.WSMinticAutogestion.vo.CentroDigitalVO;
import com.claro.WSMinticAutogestion.vo.StResultsVO;

public class STResultsDAO {
	Connection connection;
	
	
	public STResultsDAO(Connection connection) {
		super();
		this.connection = connection;
	}


	public StResultsVO  GetByWorkFlowId(String work_flow_id) {
		StResultsVO stResultsVO =null; 
		String sql = "SELECT resultID,ap_id,expected_download_mbps,expected_upload_mbps,speedtest_server_url"
				+ ",payload_download_size,payload_upload_size,result_download_mbps"
				+ ",result_upload_mbps,result_latency_ms,result_jitter_ms"
				+ ",result_start_date,result_end_date,result_code,result_execution"
				+ ",test_type,workflow_process_id,result_message  "
				+ "FROM 	STResults   WHERE 	workflow_process_id = ? and result_execution != 'running' ";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		try {
			if(this.connection.isValid(10)) {
				preparedStatement = this.connection.prepareStatement(sql);
				preparedStatement.setString(1, work_flow_id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					stResultsVO = new StResultsVO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),
							resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13),resultSet.getString(14),resultSet.getString(15),
							resultSet.getString(16),resultSet.getString(17),resultSet.getString(18));
				} 
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
				if(!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			}
		} catch (Exception e) {
			System.out.println("CentroDigitalDAO Find By Id"+e.toString());
		}
		return stResultsVO;
		
	}
	

}
