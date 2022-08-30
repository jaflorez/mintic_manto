package com.claro.WSMinticAutogestion.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpeedTestVO {
	private int speed_test_call_id;
	private String usuario;
	private String id_beneficiario;
	private Timestamp fecha;
	private String result_message;
	private String result_execution;
	private String workflow_process_id;
	private String ap_ip;
	private String download;
	private String upload;
	private String latency;
	private String jitter;
	private String payload_download_size;
	private String payload_upload_size;
	public int getSpeed_test_call_id() {
		return speed_test_call_id;
	}
	public void setSpeed_test_call_id(int speed_test_call_id) {
		this.speed_test_call_id = speed_test_call_id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(String id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
	public String getResult_execution() {
		return result_execution;
	}
	public void setResult_execution(String result_execution) {
		this.result_execution = result_execution;
	}
	public String getWorkflow_process_id() {
		return workflow_process_id;
	}
	public void setWorkflow_process_id(String workflow_process_id) {
		this.workflow_process_id = workflow_process_id;
	}
	public String getAp_ip() {
		return ap_ip;
	}
	public void setAp_ip(String ap_ip) {
		this.ap_ip = ap_ip;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getLatency() {
		return latency;
	}
	public void setLatency(String latency) {
		this.latency = latency;
	}
	public String getJitter() {
		return jitter;
	}
	public void setJitter(String jitter) {
		this.jitter = jitter;
	}
	public String getPayload_download_size() {
		return payload_download_size;
	}
	public void setPayload_download_size(String payload_download_size) {
		this.payload_download_size = payload_download_size;
	}
	public String getPayload_upload_size() {
		return payload_upload_size;
	}
	public void setPayload_upload_size(String payload_upload_size) {
		this.payload_upload_size = payload_upload_size;
	}	
	
	

}
