package com.ceg.ext;
//import java.util.Date;

public abstract class Product {
	/*
	 * Product is super class to the movieTicket,
	 * SeasonPass, MovieTicket, SeasonPass, and Refreshment
	 * children classes. Contains information related to 
	 * productCode and productType, shared by all subclasses.
	 */
	String productCode;
	char productType;
	double price;
	
	//Products constructor
	public Product(String productCode, char productType, double price) {
		this.productCode = productCode;
		this.productType = productType;
		this.price = price;
	}
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public char getProductType() {
		return productType;
	}

	public void setProductType(char productType) {
		this.productType = productType;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	
}
