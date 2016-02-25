package model;


public class Address
{
	private int addressId;
	private String address;
	private String district;
	private String postalCode;
	private String phone;
	private City city;
	
	public int getAddressId()
	{
		return addressId;
	}
	
	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getDistrict()
	{
		return district;
	}
	
	public void setDistrict(String district)
	{
		this.district = district;
	}
	
	public String getPostalCode()
	{
		return postalCode;
	}
	
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public City getCity()
	{
		return city;
	}
	
	public void setCity(City city)
	{
		this.city = city;
	}
}
