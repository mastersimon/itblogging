package server;

import java.util.Vector;

public class Address 
{
	private int addressId;
	private String address;
	private String district;
	private Vector<City> city;
	private int postalCode;
	private int phone;
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public Vector<City> getCity() {
		return city;
	}
	
	public void setCity(Vector<City> city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}
