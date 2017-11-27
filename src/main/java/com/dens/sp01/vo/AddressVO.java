package com.dens.sp01.vo;

public class AddressVO {

	private String code;
	private String name;

	public AddressVO() {
		super();
	}

	public AddressVO(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AddressVO [code=" + code + ", name=" + name + "]";
	};

}
