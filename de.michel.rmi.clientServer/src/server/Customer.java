package server;

import java.util.Vector;

public class Customer 
{
	private int customerId;
	private String firstName;
	private String lastName;
	private String eMail;
	private Vector<Address> address;
	
	public int getCustomerId(){
		return customerId;
	}
	
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Vector<Address> getAddress() {
		return address;
	}

	public void setAddress(Vector<Address> address) {
		this.address = address;
	}
}
