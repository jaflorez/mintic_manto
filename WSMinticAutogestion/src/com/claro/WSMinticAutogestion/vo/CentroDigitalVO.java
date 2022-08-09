package com.claro.WSMinticAutogestion.vo;

import java.util.List;

public class CentroDigitalVO {
	private String id_beneficiario;
	private String llave;
	private String id_mintic;
	private String nombre_ct_pob;
	private String municipio;
	private String departamento;
	private String vlan;
	private String ip_router;
	private int	server_data;
	private List<EquipoVO> equipos;
	private List<ResponsableVO> responsables;
	public CentroDigitalVO() {
		
	}
	public CentroDigitalVO(String id_beneficiario,String llave,String id_mintic,String nombre_ct_pob,String municipio,String departamento,String vlan,String ip_router,int	server_data) {
		this.id_beneficiario=id_beneficiario;
	    this.llave=llave;
	    this.id_mintic=id_mintic;
		this.nombre_ct_pob=nombre_ct_pob;
		this.municipio=municipio;
		this.departamento=departamento;
		this.vlan=vlan;
		this.ip_router=ip_router;
		this.server_data=server_data;
	}
	public String getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(String id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getId_mintic() {
		return id_mintic;
	}
	public void setId_mintic(String id_mintic) {
		this.id_mintic = id_mintic;
	}
	public String getNombre_ct_pob() {
		return nombre_ct_pob;
	}
	public void setNombre_ct_pob(String nombre_ct_pob) {
		this.nombre_ct_pob = nombre_ct_pob;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getVlan() {
		return vlan;
	}
	public void setVlan(String vlan) {
		this.vlan = vlan;
	}
	public String getIp_router() {
		return ip_router;
	}
	public void setIp_router(String ip_router) {
		this.ip_router = ip_router;
	}
	public int getServer_data() {
		return server_data;
	}
	public void setServer_data(int server_data) {
		this.server_data = server_data;
	}
	public List<EquipoVO> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<EquipoVO> equipos) {
		this.equipos = equipos;
	}
	public List<ResponsableVO> getResponsables() {
		return responsables;
	}
	public void setResponsables(List<ResponsableVO> responsables) {
		this.responsables = responsables;
	}
	
	


}
