package com.claro.WSMinticAutogestion.json;

import java.util.List;

public class Router_mk {
	private String ip_address;
	
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	private List<Interfaces_rt> interfaces;
	private List<Coneccion_rt> conectividad;
	public List<Interfaces_rt> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(List<Interfaces_rt> interfaces) {
		this.interfaces = interfaces;
	}
	public List<Coneccion_rt> getConectividad() {
		return conectividad;
	}
	public void setConectividad(List<Coneccion_rt> conectividad) {
		this.conectividad = conectividad;
	}
	
}
