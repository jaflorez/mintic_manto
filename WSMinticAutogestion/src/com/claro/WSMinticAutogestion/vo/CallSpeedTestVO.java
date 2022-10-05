package com.claro.WSMinticAutogestion.vo;

import java.util.Date;

public class CallSpeedTestVO {
	private long speed_test_call_id;
	private String 	usuario;
	private String 	ap_id;
	private String 	workflow_process_id;
	private Date fecha;
	private String 	estado;
	private Date fecha_solicitud;
	public CallSpeedTestVO(String ap_id, String workflow_process_id, String estado) {
		super();
		this.speed_test_call_id = 0;
		this.usuario = "";
		this.ap_id = ap_id;
		this.workflow_process_id = workflow_process_id;
		this.fecha = null;
		this.estado = estado;
		this.fecha_solicitud = null;
	}
	
	public CallSpeedTestVO(long speed_test_call_id, String usuario, String ap_id, String workflow_process_id,
			Date fecha, String estado,Date fecha_solicitud) {
		super();
		this.speed_test_call_id = speed_test_call_id;
		this.usuario = usuario;
		this.ap_id = ap_id;
		this.workflow_process_id = workflow_process_id;
		this.fecha = fecha;
		this.estado = estado;
		this.fecha_solicitud = fecha_solicitud;
	}
	public long getSpeed_test_call_id() {
		return speed_test_call_id;
	}
	public void setSpeed_test_call_id(long speed_test_call_id) {
		this.speed_test_call_id = speed_test_call_id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAp_id() {
		return ap_id;
	}
	public void setAp_id(String ap_id) {
		this.ap_id = ap_id;
	}
	public String getWorkflow_process_id() {
		return workflow_process_id;
	}
	public void setWorkflow_process_id(String workflow_process_id) {
		this.workflow_process_id = workflow_process_id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	

}
