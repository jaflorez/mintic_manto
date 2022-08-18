package com.claro.WSMinticAutogestion.json;

import java.util.List;

public class SpeedTest {
	private String id_beneficiario;
	private String id_user;
	private String mac_ap;
	private String fecha_ejecucion;
	private String bw_down_kbps;
	private String bw_up_kbps;
	private List<SpeedTestResponse> response;
	public String getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(String id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getMac_ap() {
		return mac_ap;
	}
	public void setMac_ap(String mac_ap) {
		this.mac_ap = mac_ap;
	}
	public String getFecha_ejecucion() {
		return fecha_ejecucion;
	}
	public void setFecha_ejecucion(String fecha_ejecucion) {
		this.fecha_ejecucion = fecha_ejecucion;
	}
	public String getBw_down_kbps() {
		return bw_down_kbps;
	}
	public void setBw_down_kbps(String bw_down_kbps) {
		this.bw_down_kbps = bw_down_kbps;
	}
	public String getBw_up_kbps() {
		return bw_up_kbps;
	}
	public void setBw_up_kbps(String bw_up_kbps) {
		this.bw_up_kbps = bw_up_kbps;
	}
	public List<SpeedTestResponse> getResponse() {
		return response;
	}
	public void setResponse(List<SpeedTestResponse> response) {
		this.response = response;
	}
	
}
