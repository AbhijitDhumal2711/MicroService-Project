package edu.jsp.userservice.dto;

import java.util.List;

import jakarta.persistence.Transient;

public class Country {

	 private	int countryId;
		
		
		private int travellerId;
		
		private int cityId;
		
		
		private String countryName;

		
		@Transient
		private City city=new City();

		
		
		


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


		public int getTravellerId() {
			return travellerId;
		}


		public void setTravellerId(int travellerId) {
			this.travellerId = travellerId;
		}


		public int getCityId() {
			return cityId;
		}


		public void setCityId(int cityId) {
			this.cityId = cityId;
		}


		public String getCountryName() {
			return countryName;
		}


		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		
		
		


   


@Override
		public String toString() {
			return "Country [countryId=" + countryId + ", travellerId=" + travellerId + ", cityId=" + cityId
					+ ", countryName=" + countryName + ", city=" + city + "]";
		}
public Country() {
	// TODO Auto-generated constructor stub
}
}
