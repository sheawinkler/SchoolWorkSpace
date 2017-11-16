package com.ceg.ext;
import java.util.ArrayList;

public class Person {
	private String personCode;
	private String name;
	private Address address;
	private ArrayList<String> email;
	private String firstName;
	private String lastName;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
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



	public ArrayList<String> getEmail() {
		return email;
	}



	public void setEmail(ArrayList<String> email) {
		this.email= email;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}

	public String getLastName() {
		return lastName;
	}


	public Person(String personCode, String name, Address address, String email) {		
		this.personCode = personCode;
		this.name = name;

		String [] K = name.split(",");
		firstName = K[0];
		lastName = K[1];

		this.address = address;
		//split email
		//for loop and add elements to this.email
		String [] emails = email.split(",");
		this.email = new ArrayList<String>();
		for(int i=0; i<emails.length; i++){
			this.email.add(emails[i]);


		}

	}
	public Person(String personCode, String name, Address address) {		
		this.personCode = personCode;
		this.name = name;

		String [] K = name.split(",");
		firstName = K[0];
		lastName = K[1];

		this.address = address;

	}
	
	public Person(String contact) {
		this.personCode = contact;
	}

	
	


}
