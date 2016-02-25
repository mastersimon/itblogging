package server;

import java.util.Vector;

public class CustomerImplementation 
{
	private static CustomerImplementation customerImpl;
	
	public CustomerImplementation() 
	{
		
	}
	
	/**
	 * Liefert das Singleton Objekt
	 * @return Singleton Objekt der Customer-Implementation
	 */
	public CustomerImplementation getSingleton()
	{
		if(customerImpl == null)
		{
			customerImpl = new CustomerImplementation();
		}
		
		return customerImpl;
	}
	
	public Vector<Customer> getCustomer()
	{
		return null;
	}
	
	

}
