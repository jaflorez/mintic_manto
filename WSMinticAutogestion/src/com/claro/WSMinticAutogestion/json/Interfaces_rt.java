package com.claro.WSMinticAutogestion.json;

public class Interfaces_rt {
	private String address;
	private String interface_;
	private String network_;
	public Interfaces_rt() {
		super();
	}
	
	public Interfaces_rt(String address, String interface_, String network_) {
		super();
		this.address = address;
		this.interface_ = interface_;
		this.network_ = network_;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInterface_() {
		return interface_;
	}
	public void setInterface_(String interface_) {
		this.interface_ = interface_;
	}
	public String getNetwork_() {
		return network_;
	}
	public void setNetwork_(String network_) {
		this.network_ = network_;
	}
	
}
