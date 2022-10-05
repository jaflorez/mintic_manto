package com.claro.WSMinticAutogestion.vo;

import java.util.Date;

public class TokenVO {
	private String token_access_point_srv1;
	private String token_access_point_srv2;
	private String token_router_switch_srv1;
	private Date fecha;
	public TokenVO(String token_access_point_srv1, String token_access_point_srv2, String token_router_switch_srv1,
			Date fecha) {
		super();
		this.token_access_point_srv1 = token_access_point_srv1;
		this.token_access_point_srv2 = token_access_point_srv2;
		this.token_router_switch_srv1 = token_router_switch_srv1;
		this.fecha = fecha;
	}
	public String getToken_access_point_srv1() {
		return token_access_point_srv1;
	}
	public void setToken_access_point_srv1(String token_access_point_srv1) {
		this.token_access_point_srv1 = token_access_point_srv1;
	}
	public String getToken_access_point_srv2() {
		return token_access_point_srv2;
	}
	public void setToken_access_point_srv2(String token_access_point_srv2) {
		this.token_access_point_srv2 = token_access_point_srv2;
	}
	public String getToken_router_switch_srv1() {
		return token_router_switch_srv1;
	}
	public void setToken_router_switch_srv1(String token_router_switch_srv1) {
		this.token_router_switch_srv1 = token_router_switch_srv1;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}
