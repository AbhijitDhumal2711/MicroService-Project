package edu.jsp.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.ratingservice.ResponseStructure;
import edu.jsp.ratingservice.dto.City;
import edu.jsp.ratingservice.dto.Country;
import edu.jsp.ratingservice.exception.CountryListNotFoundException;
import edu.jsp.ratingservice.exception.CountryNotFoundException;
import edu.jsp.ratingservice.exception.CountryNotSavedException;
import edu.jsp.ratingservice.exception.CountryNotUpdateException;
import edu.jsp.ratingservice.exception.TravellerWithCountryNotFoundException;
import edu.jsp.ratingservice.service.CountryService;
import edu.jsp.ratingservice.serviceinter.CityService;

@RestController
public class CountryController {

//	@Autowired
//	private Country country;
	
	@Autowired
	private CityService cityService;
	
@Autowired
	
	private CountryService countryService;


	
	@PostMapping("/country")
	public ResponseEntity<ResponseStructure<Country>> saveCountry(@RequestBody Country country) {
	
		Country country2=countryService.saveCountry(country);
		
		if(country2.getCountryName()!=null) {
			

			
			
			ResponseStructure< Country> responseStructure=new ResponseStructure<Country>();
			
			responseStructure.setCode(HttpStatus.CREATED.value());
			
			responseStructure.setMessage("CREATED");
			
			responseStructure.setData(country2);
			
			return new ResponseEntity<ResponseStructure<Country>>(responseStructure, HttpStatus.CREATED);
		}else {
			throw new CountryNotSavedException("NOT FOUND");
		}
		
		
	}
	
	
//	@GetMapping("/country/{id}")
//	public ResponseEntity<ResponseStructure<Country>> getOneCountry(@PathVariable int id) {
//		
//		Country country=countryService.getOneCountry(id);
//		
//		if(country!=null) {
//			ResponseStructure<Country> responseStructure=new ResponseStructure<Country>();
//			
//			responseStructure.setCode(HttpStatus.FOUND.value());
//			
//			responseStructure.setMessage("FOUND");
//			
//			responseStructure.setData(country);
//			
//			return new ResponseEntity<ResponseStructure<Country>>(responseStructure,HttpStatus.FOUND);
//		}else {
//			throw new CountryNotFoundException("NOT FOUND");
//		}
//		
//		
//	}
	
	@GetMapping("/country/{countryId}")
	public Country getOneCountry(@PathVariable("countryId") int countryId) {
		
		Country country=countryService.getOneCountry(countryId);
		
		City city=cityService.getCity(country.getCityId());
	
		country.setCity(city);
	
	   return country;	
		
	}
	
	
//	@GetMapping("/country")
//	public ResponseEntity<ResponseStructure<List<Country>>> getAllCountry(){
//		
//		List<Country> countries=countryService.getAllCountry();
//		
//		if(countries!=null&&!countries.isEmpty()) {
//			
//		ResponseStructure<List<Country>> responseStructure=new ResponseStructure<List<Country>>();
//		
//		responseStructure.setCode(HttpStatus.FOUND.value());
//		
//		responseStructure.setMessage("FOUND");
//		
//		responseStructure.setData(countries);
//		
//		return new ResponseEntity<ResponseStructure<List<Country>>>(responseStructure,HttpStatus.FOUND);
//		
//		
//		
//	}else {
//		throw new CountryListNotFoundException("NOT FOUND");
//	}
//	}
	
	
	
	
	
	@GetMapping("/country")
	public List<Country> getAllCountry(){
		
		
		List<Country> countries=countryService.getAllCountry();
		
//		List<City> city=cityService.getAllCity();
//		
//		country.setCities(city);
//		
//		countries.add(country);
		
		return countries;
		
		
	}
	
	
	
	
	
	@PutMapping("/country")
	public ResponseEntity<ResponseStructure<Country>> updateCountry(@RequestBody Country country) {
		
		Country country2=countryService.updateCountry(country);
		
		if(country!=null) {
			
			ResponseStructure<Country> responseStructure=new ResponseStructure<Country>();
			
			responseStructure.setCode(HttpStatus.FOUND.value());
			
			responseStructure.setMessage("Found");
			
			responseStructure.setData(country2);
			
			return new ResponseEntity<ResponseStructure<Country>>(responseStructure,HttpStatus.FOUND);
			
	}else {
		throw new CountryNotUpdateException("NULL VALUES NOT ACCEPTED");
	}
		
	
	}
	
	@DeleteMapping("/country/{countryId}")
	public boolean deleteCountry(@PathVariable("countryId") int countryId) {
		return countryService.deleteCountryById(countryId);
				
	}
	
	
	

	@DeleteMapping("/country/{id}")
	public ResponseEntity<ResponseStructure<Country>> deleteByCountry(@PathVariable int id) {
		
		Country country=countryService.deleteCountryWithId(id);
		
		if(country!=null) {
		ResponseStructure<Country> responseStructure=new ResponseStructure<Country>();
		
		responseStructure.setCode(HttpStatus.NO_CONTENT.value());
		
		responseStructure.setMessage("NOT CONTENT");
		
		responseStructure.setData(country);
		
		
		return new ResponseEntity<ResponseStructure<Country>>(responseStructure,HttpStatus.NO_CONTENT);
		
		}else {
			
			ResponseStructure<Country> responseStructure=new ResponseStructure<Country>();
			
			responseStructure.setCode(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("NOT FOUND");
			
			responseStructure.setData(country);
			
			
			return new ResponseEntity<ResponseStructure<Country>>(responseStructure,HttpStatus.NOT_FOUND);
			
		}
	}

	
	
	
	
	

	
	
	//For Traveller id
	
//	@GetMapping("/traveller/{travellerId}")
//	public ResponseEntity<ResponseStructure<List<Country>>> getAllCountryByTravellerId(@PathVariable("travellerId") int travellerId){
//		
//		List<Country> countries=countryService.getAllCountry();
//		
//		if(countries!=null && !countries.isEmpty()) {
//			
//			ResponseStructure<List<Country>> responseStructure=new ResponseStructure<List<Country>>();
//			
//			responseStructure.setCode(HttpStatus.FOUND.value());
//			
//			responseStructure.setMessage("FOUND");
//			
//			responseStructure.setData(countries);
//			
//			return new ResponseEntity<ResponseStructure<List<Country>>>(responseStructure,HttpStatus.FOUND);
//			
//			
//			
//		}else {
//			throw new TravellerWithCountryNotFoundException("NOT FOUND");
//		}
//		
//		}
	
	
	
	@GetMapping("/traveller/{travellerId}")
	public List<Country> getAllCountryByTravellerId(@PathVariable("travellerId") int travellerId){
		
		return countryService.getAllCountry();
			
			
		
		}
	
	
	
	
	
	
	//For City id
	@GetMapping("/city/{cityId}")
	public List<Country> getAllCountryByCityId(@PathVariable("cityId") int cityId){
		
		return countryService.saveCountrys2(cityId);
	}
	
	
}
