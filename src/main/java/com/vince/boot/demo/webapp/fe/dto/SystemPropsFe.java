package com.vince.boot.demo.webapp.fe.dto;

public class SystemPropsFe extends BaseFe {

	private static final long serialVersionUID = 1L;

	private String keyProp;
	private String valueProp;

	public SystemPropsFe() {
	}

	public String getKeyProp() {
		return this.keyProp;
	}

	public void setKeyProp(String keyProp) {
		this.keyProp = keyProp;
	}

	public String getValueProp() {
		return this.valueProp;
	}

	public void setValueProp(String valueProp) {
		this.valueProp = valueProp;
	}

}
