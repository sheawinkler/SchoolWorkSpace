package com.ceg.ext;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Driver {
	public static void main (String[] args) throws SQLException {

		File f1 = new File("data/Products.dat");
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			products = FileReader.ProductFile(f1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File f2 = new File("data/Customers.dat");
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			customers = FileReader.CustomerFile(f2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File f3 = new File("data/Persons.dat");
		ArrayList<Person> persons = new ArrayList<Person>();
		try{
			persons = FileReader.PersonFile(f3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File f4 = new File("data/Invoices.dat");
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		//try{
		//	invoices = FileReader.InvoiceFile(f4);
		//}catch (IOException e) {
		//	e.printStackTrace();
		//}
				
		InvoiceReport.ExecutiveSummary(products, customers, persons, invoices);
		InvoiceReport.IndividualDetailReports(products,customers, persons, invoices);
		
	}

}
