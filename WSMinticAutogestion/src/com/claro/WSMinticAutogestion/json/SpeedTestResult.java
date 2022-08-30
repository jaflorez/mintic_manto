package com.claro.WSMinticAutogestion.json;

import com.claro.WSMinticAutogestion.vo.StResultsVO;

public class SpeedTestResult {
	private String estado; 
	private String id_user;
	private String workflow_process_id;
	private String fecha_solicitud;
	private String ap_id;
	private String expected_download_mbps;
	private String expected_upload_mbps;
	private String payload_download_size;
	private String payload_upload_size;
	private String result_download_mbps;	
	private String result_upload_mbps;	
	private String result_latency_ms;	
	private String result_jitter_ms;	
	private String result_start_date; 
	private String result_end_date;	
	private String result_code;	
	private String result_execution;
	private String result_message;
	public SpeedTestResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SpeedTestResult(String id_user, String ap_id,String estado,String fecha_solicitud) {
		super();
		this.id_user = id_user;
		this.ap_id = ap_id;
		this.estado = estado;
		this.fecha_solicitud = fecha_solicitud;
	}
	public void setStResultVO(StResultsVO resultsVO ) {
		this.workflow_process_id = resultsVO.getWorkflow_process_id();
		this.expected_download_mbps = resultsVO.getExpected_download_mbps();
		this.expected_upload_mbps = resultsVO.getExpected_upload_mbps();
		this.expected_download_mbps = resultsVO.getExpected_download_mbps();
		this.expected_upload_mbps = resultsVO.getExpected_upload_mbps();
		this.payload_download_size = resultsVO.getPayload_download_size();
		this.payload_upload_size = resultsVO.getPayload_upload_size();
		this.result_download_mbps = resultsVO.getResult_download_mbps();
		this.result_upload_mbps =  resultsVO.getResult_upload_mbps();
		this.result_latency_ms = resultsVO.getResult_latency_ms();
		this.result_jitter_ms = resultsVO.getResult_jitter_ms();
		this.result_start_date = resultsVO.getResult_start_date(); 
		this.result_end_date =  resultsVO.getResult_end_date();
		this.result_code =  resultsVO.getResult_code();
		this.result_execution = resultsVO.getResult_execution();
		this.result_message = resultsVO.getResult_message();
	}
	


	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getWorkflow_process_id() {
		return workflow_process_id;
	}
	public void setWorkflow_process_id(String workflow_process_id) {
		this.workflow_process_id = workflow_process_id;
	}
	public String getAp_id() {
		return ap_id;
	}
	public void setAp_id(String ap_id) {
		this.ap_id = ap_id;
	}
	public String getExpected_download_mbps() {
		return expected_download_mbps;
	}
	public void setExpected_download_mbps(String expected_download_mbps) {
		this.expected_download_mbps = expected_download_mbps;
	}
	public String getExpected_upload_mbps() {
		return expected_upload_mbps;
	}
	public void setExpected_upload_mbps(String expected_upload_mbps) {
		this.expected_upload_mbps = expected_upload_mbps;
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
	public String getResult_download_mbps() {
		return result_download_mbps;
	}
	public void setResult_download_mbps(String result_download_mbps) {
		this.result_download_mbps = result_download_mbps;
	}
	public String getResult_upload_mbps() {
		return result_upload_mbps;
	}
	public void setResult_upload_mbps(String result_upload_mbps) {
		this.result_upload_mbps = result_upload_mbps;
	}
	public String getResult_latency_ms() {
		return result_latency_ms;
	}
	public void setResult_latency_ms(String result_latency_ms) {
		this.result_latency_ms = result_latency_ms;
	}
	public String getResult_jitter_ms() {
		return result_jitter_ms;
	}
	public void setResult_jitter_ms(String result_jitter_ms) {
		this.result_jitter_ms = result_jitter_ms;
	}
	public String getResult_start_date() {
		return result_start_date;
	}
	public void setResult_start_date(String result_start_date) {
		this.result_start_date = result_start_date;
	}
	public String getResult_end_date() {
		return result_end_date;
	}
	public void setResult_end_date(String result_end_date) {
		this.result_end_date = result_end_date;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_execution() {
		return result_execution;
	}
	public void setResult_execution(String result_execution) {
		this.result_execution = result_execution;
	}
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}

	
}
