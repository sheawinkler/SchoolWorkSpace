package com.ceg.ext;
import java.util.ArrayList;

public class InvoiceReport {
	//read out data fields and methods to return necessary calculations.
	//use String formatting to format output to match examples identically
	public static void ExecutiveSummary(ArrayList<Product> products, ArrayList<Customer> customers, 
			ArrayList<Person> persons, ArrayList<Invoice> invoices){
		System.out.println("==========================");
		System.out.println("Executive Summary Report");
		System.out.println("==========================");
		System.out.println(String.format("%-10s %-40s %-30s %-15s %-12s %-12s %-12s %-12s", 
				"Invoice","Customer","Salesperson","Subtotal","Fees","Taxes","Discount","Total"));
		//loop through and print out invoice summary
		//print in format similar to above
		//for (inv : invArrayList) {}
		for (int i = 0; i < invoices.size(); i++){

			//set Company Name
			String CompanyName = getCompanyName(customers, invoices, i);
			//set salesperson
			String salesperson = getSalesperson(persons, invoices, i);
			//calculate subtotal
			double subtotal = calculateSubtotal(products,invoices.get(i).getProductlist());
			//caluclate fees

			System.out.println(String.format("%-10s %-40s %-30s %-15s %-12s %-12s %-12s %-12s", 
					invoices.get(i).getInvoiceCode(),CompanyName,
					salesperson,subtotal,"Fees","Taxes","Discount","Total"));
		}
		System.out.println("========================================================================="+
				"=========================================================================");
		//formatting change from %s to %f (float)
		System.out.println(String.format("%-80s $  %-10s $  %-10s", "TOTALS","EXAMPLE", "EXAMPLE"));

		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

	}

	public static void IndividualDetailReports(ArrayList<Product> products, ArrayList<Customer> customers, 
			ArrayList<Person> persons, ArrayList<Invoice> invoices ){
		System.out.println("Individual Invoice Detail Reports");
		System.out.println("==================================================");

		for (int i = 0; i < invoices.size(); i++){
			//print out invoiceNumber, "Salesperson: "+Salesperson's name,
			System.out.println(String.format(invoices.get(i).getInvoiceCode()));
			System.out.println("========================");
			System.out.println("Salesperson: "+getSalesperson(persons,invoices,i));
			System.out.println("Customer Info: ");
			System.out.println(getCompanyName(customers,invoices,i)+" ("+invoices.get(i).getCustomerCode()+")");
			System.out.println("["+getCustomerType(customers,invoices,i)+"]");
			//System.out.println(invoices.get(i).get);
			System.out.println("-------------------------------------------");
			//	String.format("%-10s %-40s %-30s %-15s %-12s %-12s %-12s %-12s", 
			//			invoices.get(i).getInvoiceCode(),CompanyName,
			//			salesperson,subtotal,"Fees","Taxes","Discount","Total"))
			//for(int z = 0; z < (PL.size()+2); z++){	
			//	System.out.println(String.format("%-10s %-80s %-30s %-15s %-12s",products.get(z).getProductCode(),products.get(i).getProductType(),"1","1","1"));
			//}
			//}	
			System.out.println(String.format("%-10s %-80s %-30s %-15s %-12s","Code","Item","SubTotal","Tax","Total"));
			//get product code from invoice.dat
			
			for(int j = 0; j < products.size(); j++ ){
			String pc = invoices.get(j).getProductCode();	
			System.out.println(pc);
			
			/*System.out.println(String.format("%-10s %-40s %-30s %-15s %-12s %-12s %-12s %-12s", 
					invoices.get(i).getInvoiceCode(),CompanyName,
					salesperson,subtotal,"Fees","Taxes","Discount","Total"));
					*/
			System.out.println(String.format("%-10s %-80s %-30s %-15s %-12s", 
					pc,"1","2","32","45"));
			}
			//System.out.println(String.format("%-10s %-80s %-30s %-15s %-12s",
			//		Invoice.getProductlist()),pc,"1","q");

			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");	
		}

	}

	//method to get the type of the customer(General/Student)
	public static String getCustomerType(ArrayList<Customer> customers, ArrayList<Invoice> invoices, int i){
		String customerType = "";
		String T = "";
		for(int j = 0; j< customers.size(); j++){
			if( invoices.get(i).getCustomerCode().equalsIgnoreCase(customers.get(j).getCustomerCode())){
				T = customers.get(j).getType();
				if(T.equalsIgnoreCase("G")){
					customerType = "General";
				}else if(T.equalsIgnoreCase("S")){
					customerType = "Student";
				}

			}

		}
		return customerType;
	}

	//method to return company name for invoice
	public static String getCompanyName(ArrayList<Customer> customers, ArrayList<Invoice> invoices, int i) {
		String name = "";
		for (int j = 0; j< customers.size(); j++){
			if ( invoices.get(i).getCustomerCode().equalsIgnoreCase(customers.get(j).getCustomerCode() )) {
				name = customers.get(j).getName();
			}
		}
		return name;
	}

	//method to return salesperson for the invoice
	public static String getSalesperson(ArrayList<Person> persons, ArrayList<Invoice> invoices, int i) {
		String salesperson = "";
		for (int j = 0; j< persons.size(); j++){
			if ( invoices.get(i).getSalespersonCode().equalsIgnoreCase(persons.get(j).getPersonCode())) {
				salesperson = persons.get(j).getName();
			}
		}
		return salesperson;
	}

	public static String getProductCode(ArrayList<Product> products, ArrayList<String> PL){
		String productCode = "x";
		for(int i = 0; i<PL.size(); i++){
			String [] plSplit = PL.get(i).split(":");
			productCode = plSplit[0];
			System.out.println(productCode);
		}
		return productCode;

	}

	//method to calculate the subtotal of the invoice
	public static double calculateSubtotal(ArrayList<Product> products, ArrayList<String> PL) {
		double subtotal = 0.0;
		//loop through individual invoice product list
		for (int i = 0; i < PL.size(); i++) {
			//split each product to compare to products list
			String [] plSplit = PL.get(i).split(":");

			if (plSplit.length == 2) {
				//loop through products list for a match

				for (int j = 0; j < products.size(); j++) {

					if (plSplit[0].equalsIgnoreCase(products.get(j).getProductCode())){
						subtotal += products.get(j).getPrice() * Double.parseDouble(plSplit[1]);
					}
				}
			}
			else if (plSplit.length == 3) {
				subtotal += 0;
			}
		}

		return subtotal;
	}
	
	public static double getFees(ArrayList<Customer> customers, ArrayList<Product> products, 
			ArrayList<String> PL, ArrayList<Invoice> invoices, int loopPlace) {
		double fees = 0.0;
		
		
		for (int i = 0; i < customers.size(); i++) {
			//compare for matching customer codes to find customer type
			if (customers.get(i).getCustomerCode() == invoices.get(i).getCustomerCode()){
				if (customers.get(i).getType().equals('G')){
					//need to loop through products list to determine fees based on types
					fees += 10;
				}
				else{ 
					fees = 0; 
				}
				
			}
		}
		
		return fees;
	}



}
