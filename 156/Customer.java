package com.ceg.ext;


public class Customer {
	private String customerCode;
	private String type;
	private String contact;
	private String name;
	private Address address;

	public Customer(String customerCode, String type, String contact, String name, Address address) {
		this.contact = contact;
		this.customerCode = customerCode;
		this.type = type;
		this.name = name;
		this.address = address;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}


	public String getcontact() {
		return this.contact;
	}

	public void setcontact(String contact) {
		this.contact = contact;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address.getStreet() + this.address.getCity() + 
				this.address.getState() + this.address.getZip() + 
				this.address.getCountry();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	




}
