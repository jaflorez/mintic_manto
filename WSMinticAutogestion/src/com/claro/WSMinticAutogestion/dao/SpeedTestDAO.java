package com.claro.WSMinticAutogestion.dao;

import java.sql.Connection;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.claro.WSMinticAutogestion.vo.SpeedTestVO;
import com.claro.WSMinticAutogestion.vo.SpeedTestResponseVO;

public class SpeedTestDAO {
	private Connection connection;

	public SpeedTestDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	public SpeedTestVO FindByMac(String mac,String usuario,int timeOut ) {
		SpeedTestVO speedTestVO = new SpeedTestVO();
		speedTestVO.setMac(mac);
		speedTestVO.setUsuario(usuario);
		speedTestVO.setSpeedTestResponseVOs(this.FindResponseByMac(mac));
		return speedTestVO;
	}
	private List<SpeedTestResponseVO> FindResponseByMac(String mac) {
		List<SpeedTestResponseVO> lstResponse = new ArrayList<>();
		SpeedTestResponseVO responseVO;
		responseVO = new SpeedTestResponseVO("200", "123", "12", "45");
		lstResponse.add(responseVO);
		responseVO = new SpeedTestResponseVO("200", "123", "12", "45");
		lstResponse.add(responseVO);
		responseVO = new SpeedTestResponseVO("200", "123", "12", "45");
		lstResponse.add(responseVO);
		responseVO = new SpeedTestResponseVO("200", "123", "12", "45");
		lstResponse.add(responseVO);
		return lstResponse;
	}
}
