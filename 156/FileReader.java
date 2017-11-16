package com.ceg.ext;

import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FileReader {

	public static ArrayList<Person>PersonFile(File file)throws IOException, SQLException{

		ArrayList<Person> p = new ArrayList<Person>();

		Connection conn = DatabaseInfo.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();

		try{

			String query = "SELECT Person_Code,Person_Name,Address_ID,Person_ID FROM persons;";	
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){

				String personCode = rs.getString("Person_Code");
				String name = rs.getString("Person_Name");
				int Address_ID = rs.getInt("Address_ID");
				int Person_ID = rs.getInt("Person_ID");
				
				String query1 = "SELECT * FROM email JOIN persons WHERE email.Person_ID = persons.Person_ID; ";
				ResultSet rs1 = stmt.executeQuery(query1);
				
				while(rs.next()){
				int Person_ID1 = rs.getInt("Person_ID");
								
					String Email = rs1.getString("email");
					
					ArrayList<String> email = new ArrayList<String>();
					email.add(Email);
					
				}
			
				}
		
			
			//Person(String personCode, String name, Address address, String email)
		
			rs.close(); 
			stmt.close(); 
			conn.close();
		} catch (SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return p;

	}


	public static ArrayList<Customer>CustomerFile(File file)throws IOException, SQLException{

		ArrayList<Customer> c = new ArrayList<Customer>();
		Connection conn = DatabaseInfo.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();

		try{

			String query = "SELECT Customer_Code,Customer_Type,PrimaryContact_ID,Customer_Name,Address_ID FROM customers;";	
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){

				String Customer_Code = rs.getString("Customer_Code");
				String Customer_Type = rs.getString("Customer_Type");
				int PrimaryContact_ID = rs.getInt("PrimaryContact_ID");
				String Customer_Name = rs.getString("Customer_Name");
				int Address_ID = rs.getInt("Address_ID");

			}

			rs.close(); 
			stmt.close(); 
			conn.close();

		} catch (SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return c;
	}

	public static ArrayList<Product>ProductFile(File file)throws IOException, SQLException{
		ArrayList<Product> p = new ArrayList<Product>();
		Connection conn = DatabaseInfo.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();

		try{

			String query = "SELECT Product_ID,Product_Code,Product_Type FROM products;";	
			ResultSet rs1 = stmt.executeQuery(query);
			
			ResultSet rs2 = null;
			Statement stmt2 = null;
			stmt2 = conn.createStatement();
			
			ResultSet rs3 = null;
			Statement stmt3 = null;
			stmt3 = conn.createStatement();
			
			ResultSet rs4 = null;
			Statement stmt4 = null;
			stmt4 = conn.createStatement();
			
			ResultSet rs5 = null;
			Statement stmt5 = null;
			stmt5 = conn.createStatement();
			
			while(rs1.next()){
				int Product_ID = rs1.getInt("Product_ID");
				String Product_Code = rs1.getString("Product_Code");
				String Product_Type = rs1.getString("Product_Type");
				
				switch (Product_Type.charAt(0)){
				case 'R': {
				String query1 = "SELECT * FROM refreshment;";
				rs2 = stmt2.executeQuery(query1);
				}
				case 'P': {
				String query1 = "SELECT * FROM parkingPasses;";
				rs3 = stmt3.executeQuery(query1);	
				}
				case 'S': {
				String query1 = "SELECT * FROM seasonPasses; ";
				rs4 = stmt4.executeQuery(query1);					
				}
				case 'M': {
				String query1 = "SELECT * FROM movieTickets;";
				rs5 = stmt5.executeQuery(query1);	
				}
				}				 	
			}

			rs1.close(); 
			stmt.close(); 
			conn.close();
			
		} catch (SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return p;
	}
	/*
	public static InvoiceList<Invoice>InvoiceFile(File file)throws IOException, SQLException{

		InvoiceList c = new InvoiceList();
		Connection conn = DatabaseInfo.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();

		try{

			String query = "SELECT Invoice_Code,Customer_Code,Salesperson_Code,Invoice_Date,Invoice_ID FROM invoices;";	
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){

				String Invoice_Code = rs.getString("Invoice_Code");
				String Customer_Code = rs.getString("Customer_Code");
				String Salesperoson_Code = rs.getString("Salesperson_Code");
				String Invoice_Date = rs.getString("Invoice_Date");
				int Invoice_ID = rs.getInt("Invoice_ID");

			}

			rs.close(); 
			stmt.close(); 
			conn.close();

		} catch (SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return c;
	}
		*/	

}



