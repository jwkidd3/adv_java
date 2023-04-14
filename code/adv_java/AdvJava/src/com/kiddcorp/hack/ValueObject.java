package com.kiddcorp.hack;

public class ValueObject {
	private String name;
	String address;
	public int zip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZip() {
		return zip;
	}
	private void setZip(int zip) {
		this.zip = zip;
	}

}
