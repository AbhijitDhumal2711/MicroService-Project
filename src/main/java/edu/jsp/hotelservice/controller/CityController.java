package edu.jsp.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.hotelservice.dto.City;
import edu.jsp.hotelservice.service.CityService;

@RestController
public class CityController {

	
	

	@Autowired 
	
	private CityService cityService;
	
	@PostMapping("/city")
	public City saveCity(@RequestBody City city) {
		
		return cityService.saveCity(city);
	}
	
	
	@GetMapping("/city")
	public List<City> getAllCity() {
		return cityService.getAllCity();
	}
	
	
	@GetMapping("/city/{cityId}")
	public City getOneCity(@PathVariable("cityId") int cityId) {
		return cityService.getOneCity(cityId);
	}
	
	
	@PutMapping("/city")
	public City updateCity(@RequestBody City city ) {
		
		return cityService.updateCity(city);
	}
	
	
	@DeleteMapping("/city")
	public boolean deleteCity(City city) {
		return cityService.deleteCity(city);
	}

	
	
	
}
