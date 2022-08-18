package com.claro.WSMinticAutogestion.json;

public class SpeedTestResponse {
	private String download;
	private String upload;
	private String latency;
	private String jitter;
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

}
