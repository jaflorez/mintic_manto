package com.claro.WSMinticAutogestion.vo;

public class EquipoVO {
	private String id_beneficiario;
	private String mac;
	private String tipo;
	public EquipoVO(String id_beneficiario,String mac,String tipo) {
		this.id_beneficiario = id_beneficiario;
		this.mac = mac;
		this.tipo = tipo;
	}
	public String getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(String id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
