package com.claro.WSMinticAutogestion.json;

public class Radio {
	private String status;
	private String lan_mode_status;
	private String lan_speed_status;
    private String dl_rssi;
    private String dl_snr;
    private String mac;
    private String ap_mac;
    private String tower;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLan_mode_status() {
		return lan_mode_status;
	}
	public void setLan_mode_status(String lan_mode_status) {
		this.lan_mode_status = lan_mode_status;
	}
	public String getLan_speed_status() {
		return lan_speed_status;
	}
	public void setLan_speed_status(String lan_speed_status) {
		this.lan_speed_status = lan_speed_status;
	}
	public String getDl_rssi() {
		return dl_rssi;
	}
	public void setDl_rssi(String dl_rssi) {
		this.dl_rssi = dl_rssi;
	}
	public String getDl_snr() {
		return dl_snr;
	}
	public void setDl_snr(String dl_snr) {
		this.dl_snr = dl_snr;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getAp_mac() {
		return ap_mac;
	}
	public void setAp_mac(String ap_mac) {
		this.ap_mac = ap_mac;
	}
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}

    
    
}
