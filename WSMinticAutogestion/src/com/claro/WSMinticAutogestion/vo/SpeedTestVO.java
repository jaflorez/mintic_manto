package com.claro.WSMinticAutogestion.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpeedTestVO {
	private String usuario;
	private String mac;
	private Timestamp fecha;
	private List<SpeedTestResponseVO> speedTestResponseVOs;
	
	
	public List<SpeedTestResponseVO> getSpeedTestResponseVOs() {
		return speedTestResponseVOs;
	}
	public void setSpeedTestResponseVOs(List<SpeedTestResponseVO> speedTestResponseVOs) {
		this.speedTestResponseVOs = speedTestResponseVOs;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	

}
