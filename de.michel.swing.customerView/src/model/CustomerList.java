package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import database.DatabaseConnection;

public class CustomerList
{
	private static CustomerList instance;
	
	public static CustomerList getInstance()
	{
		if(instance == null)
		{
			instance = new CustomerList();
		}
		
		return instance;
	}
	
	public Vector<Customer> getCustomerList() 
	{
		Connection con = DatabaseConnection.getInstance();
		if(con != null)
		{
			Vector<Customer> customerList = new Vector<Customer>();
			try
			{
				String sql = "SELECT * FROM customer cu " +
											"JOIN address a ON cu.address_id = a.address_id " +
											"JOIN city ci ON a.city_id = ci.city_id " +
											"JOIN country co ON ci.country_id = co.country_id ";
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(sql);
				
				while(result.next())
				{
					Customer customer = new Customer();
					
					// Basic
					customer.setFirstName(result.getString("first_Name"));
					customer.setLastName(result.getString("last_Name"));
					customer.seteMail(result.getString("email"));
					customer.setActive(result.getBoolean("active"));
					customer.setCreationDate(result.getDate("create_Date"));
					customer.setLastUpdate(result.getDate("last_update"));
					
					// Adresse
					Address customerAddress = new Address();
					customerAddress.setAddress(result.getString("address"));
					customerAddress.setDistrict(result.getString("district"));
					customer.setAddress(customerAddress);
					
					// City
					City customerCity = new City();
					customerCity.setCity("city");
					customerAddress.setCity(customerCity);
					
					// Country
					Country customerCountry = new Country();
					customerCountry.setCountry("country");
					customerCity.setCountry(customerCountry);
					
					// Kunde der Liste hinzufügen
					customerList.add(customer);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return customerList;
		}
		return null;
	}
	
	public Vector<Customer> getCustomerListByCountry()
	{
		return null;
	}
}
