package model;

public class Customer
{
	private String firstName;
	private String lastName;
	private String eMail;
	private boolean isActive;
	
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
	
	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public boolean isActive()
	{
		return isActive;
	}

	@Override
	public String toString()
	{
		return lastName + ", " + firstName; 
	}
}
