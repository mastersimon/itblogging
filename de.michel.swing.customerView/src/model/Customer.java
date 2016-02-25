package model;

import java.util.Date;

public class Customer
{
	private int customerId;
	private int storeId;
	private boolean isActive;
	private String firstName;
	private String lastName;
	private String eMail;
	private Address address;
	private Date creationDate;
	private Date lastUpdate;
	
	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	
	public int getStoreId()
	{
		return storeId;
	}

	public void setStoreId(int storeId)
	{
		this.storeId = storeId;
	}
	
	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String geteMail()
	{
		return eMail;
	}
	
	public void seteMail(String eMail)
	{
		this.eMail = eMail;
	}
	
	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	public Date getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public Date getLastUpdate()
	{
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}

	public String toString()
	{
		return firstName + " " + lastName;
	}
}
