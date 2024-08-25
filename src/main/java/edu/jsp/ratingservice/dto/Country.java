package edu.jsp.ratingservice.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Country {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private	int countryId;
	
	
	private int cityId;
	
	private int travellerId;
	
	private String countryName;
	
	@Transient
	private City city;
	
	@Transient
	private List<City> cities=new ArrayList<City>();
	
	
	

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(int travellerId) {
		this.travellerId = travellerId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	
	
	

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", cityId=" + cityId + ", travellerId=" + travellerId
				+ ", countryName=" + countryName + ", city=" + city + "]";
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}


}
