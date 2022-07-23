package com.claro.WSMinticAutogestion.vo;

public class ResponsableVO {
	private int id_responsable;
	private String id_beneficiario;
	private String name_resp;
	private String phone;
	private String email;
	public ResponsableVO(int id_responsable,String id_beneficiario, String name_resp, String phone, String email) {
		super();
		this.id_beneficiario = id_beneficiario;
		this.id_responsable = id_responsable;
		this.name_resp = name_resp;
		this.phone = phone;
		this.email = email;
	}
	public String getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(String id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}
	public int getId_responsable() {
		return id_responsable;
	}
	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}
	public String getName_resp() {
		return name_resp;
	}
	public void setName_resp(String name_resp) {
		this.name_resp = name_resp;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
