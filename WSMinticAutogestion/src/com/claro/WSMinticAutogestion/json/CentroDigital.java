package com.claro.WSMinticAutogestion.json;

import java.util.List;

import com.claro.WSMinticAutogestion.vo.ResponsableVO;

public class CentroDigital {
	private String id_beneficiario;
	private String id_mintic;
	private String nombre_ct_pob;
	private String municipio;
	private String departamento;
	private String vlan;
	private String ap_id;
	private Radio radio_cd;
	private Radio radio_bts;
	private Router_mk router_mk;
	private Switch_bts switch_bts;
	private List<Coneccion_rt> conectividad;
	private List<AccessPoint> aps;
	private List<ResponsableVO> responsables;
	
	public String getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(String id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
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
	public Radio getRadio_cd() {
		return radio_cd;
	}
	public void setRadio_cd(Radio radio_cd) {
		this.radio_cd = radio_cd;
	}
	public Radio getRadio_bts() {
		return radio_bts;
	}
	public void setRadio_bts(Radio radio_bts) {
		this.radio_bts = radio_bts;
	}
	public Router_mk getRouter_mk() {
		return router_mk;
	}
	public void setRouter_mk(Router_mk router_mk) {
		this.router_mk = router_mk;
	}
	public Switch_bts getSwitch_bts() {
		return switch_bts;
	}
	public void setSwitch_bts(Switch_bts switch_bts) {
		this.switch_bts = switch_bts;
	}
	public List<ResponsableVO> getResponsables() {
		return responsables;
	}
	public void setResponsables(List<ResponsableVO> responsables) {
		this.responsables = responsables;
	}
	public List<Coneccion_rt> getConectividad() {
		return conectividad;
	}
	public void setConectividad(List<Coneccion_rt> conectividad) {
		this.conectividad = conectividad;
	}
	public List<AccessPoint> getAps() {
		return aps;
	}
	public void setAps(List<AccessPoint> aps) {
		this.aps = aps;
	}
	public String getAp_id() {
		return ap_id;
	}
	public void setAp_id(String ap_id) {
		this.ap_id = ap_id;
	}
	
	
}
