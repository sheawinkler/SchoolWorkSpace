package com.ceg.ext;
import java.util.ArrayList;

public class Invoice {
	private String invoiceCode;
	private String customerCode;
	private String salespersonCode;
	private String invoiceDate;
	private static ArrayList<String> productlist;
	private String productCode;

	public String getProductCode() {
		if(productlist.size() == 2){
			productCode = productlist.get(0);
		}
		else if(productlist.size() == 3){
			productCode = productlist.get(1);
		}
	return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Invoice(String invoiceCode, String customerCode, String salespersonCode, String invoiceDate,ArrayList<String> productlist){
		this.invoiceCode=invoiceCode;
		this.customerCode=customerCode;
		this.salespersonCode=salespersonCode;
		this.invoiceDate=invoiceDate;
		this.productlist=productlist;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}	
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getSalespersonCode() {
		return salespersonCode;
	}
	public void setSalespersonCode(String salespersonCode) {
		this.salespersonCode = salespersonCode;
	}
	
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	
	public static ArrayList<String> getProductlist() {
		return productlist;
	}
	public void setProductlist(ArrayList<String> productlist) {
		this.productlist = productlist;
	}



}
