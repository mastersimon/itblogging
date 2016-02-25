package server;

import java.util.Vector;

public class City 
{
	private int cityId;
	private String city;
	private Vector<Country> country;
	
	public int getCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Vector<Country> getCountry() {
		return country;
	}
	
	public void setCountry(Vector<Country> country) {
		this.country = country;
	}
}
