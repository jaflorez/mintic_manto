package com.claro.WSMinticAutogestion.vo;

public class StResultsVO {
	private String resultID;
	private String ap_id;
	private String expected_download_mbps;
	private String expected_upload_mbps;
	private String speedtest_server_url;
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
	private String test_type;
	private String workflow_process_id;
	private String result_message;
	
	public StResultsVO(String resultID, String ap_id, String expected_download_mbps, String expected_upload_mbps,
			String speedtest_server_url, String payload_download_size, String payload_upload_size,
			String result_download_mbps, String result_upload_mbps, String result_latency_ms, String result_jitter_ms,
			String result_start_date, String result_end_date, String result_code, String result_execution,
			String test_type, String workflow_process_id, String result_message) {
		super();
		this.resultID = resultID;
		this.ap_id = ap_id;
		this.expected_download_mbps = expected_download_mbps;
		this.expected_upload_mbps = expected_upload_mbps;
		this.speedtest_server_url = speedtest_server_url;
		this.payload_download_size = payload_download_size;
		this.payload_upload_size = payload_upload_size;
		this.result_download_mbps = result_download_mbps;
		this.result_upload_mbps = result_upload_mbps;
		this.result_latency_ms = result_latency_ms;
		this.result_jitter_ms = result_jitter_ms;
		this.result_start_date = result_start_date;
		this.result_end_date = result_end_date;
		this.result_code = result_code;
		this.result_execution = result_execution;
		this.test_type = test_type;
		this.workflow_process_id = workflow_process_id;
		this.result_message = result_message;
	}
	public String getResultID() {
		return resultID;
	}
	public void setResultID(String resultID) {
		this.resultID = resultID;
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
	public String getSpeedtest_server_url() {
		return speedtest_server_url;
	}
	public void setSpeedtest_server_url(String speedtest_server_url) {
		this.speedtest_server_url = speedtest_server_url;
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
	public String getTest_type() {
		return test_type;
	}
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	public String getWorkflow_process_id() {
		return workflow_process_id;
	}
	public void setWorkflow_process_id(String workflow_process_id) {
		this.workflow_process_id = workflow_process_id;
	}
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
	
	
	

}