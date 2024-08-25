package edu.jsp.hotelservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.hotelservice.dto.City;
import edu.jsp.hotelservice.repos.CityRepos;


@Service
public class CityService {

	
@Autowired
	
	private CityRepos cityRepos;
	
	public City saveCity(City city) {
		
		return cityRepos.save(city);
	}
	
	
	public City getOneCity(int id) {
		return cityRepos.findById(id).get();
	}
	
	
	public List<City> getAllCity(){
		
		return cityRepos.findAll();
		
	}
	
	public City updateCity(City city) {
		return cityRepos.save(city);
	}
	
	
	public boolean deleteCity(City city) {
		try {
			
			cityRepos.delete(city);
			
			return true;
			
			
			
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
	}

	
	
}
