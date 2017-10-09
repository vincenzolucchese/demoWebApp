package com.vince.boot.demo.webapp.beAndFe.dto;

public class SystemPropsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String keyProp;
	private String valueProp;

	public SystemPropsDto() {
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
