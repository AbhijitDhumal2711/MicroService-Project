package edu.jsp.userservice.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class Traveller {


	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	 
	private int travellerId;
	
	private String name;
	
	
	
	@Transient
	List<Country> countries=new ArrayList<>();
	
	
	
	
	



	

		public int getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(int travellerId) {
		this.travellerId = travellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	
  	


@Override
	public String toString() {
		return "Traveller [travellerId=" + travellerId + ", name=" + name + ", countries=" + countries + "]";
	}

public Traveller() {
	// TODO Auto-generated constructor stub
}



	
}
