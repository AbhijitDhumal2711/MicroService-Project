package edu.jsp.userservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmCompositeIdType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.Logger;
import edu.jsp.userservice.dto.City;
import edu.jsp.userservice.dto.Country;
import edu.jsp.userservice.dto.Traveller;
import edu.jsp.userservice.exception.TravellerListNotFoundException;
import edu.jsp.userservice.exception.TravellerNotFoundException;
import edu.jsp.userservice.exception.TravellerNotSavedException;
import edu.jsp.userservice.exception.TravellerNotUpdateException;
import edu.jsp.userservice.feign.CityService;
import edu.jsp.userservice.feign.CountryServicess;

import edu.jsp.userservice.respossestructure.ResponseStructure;
import edu.jsp.userservice.service.TravellerService;

@RestController
public class TravellerController {

//	@Autowired
//	
//	private Country country2;
	@Autowired
	private CountryServicess servicess;

	@Autowired
	private CityService cityService;
	
@Autowired
	
	private TravellerService service;
	
@Autowired

private RestTemplate restTemplate;

private Country country =new Country();

private org.slf4j.Logger logger=LoggerFactory.getLogger(TravellerService.class);
	
	@PostMapping("/traveller")
	@ResponseBody
	public ResponseEntity<ResponseStructure<Traveller>> saveTraveller(@RequestBody Traveller traveller) {
		
		if(traveller.getName()!=null ) {
			ResponseStructure<Traveller> responseStructure=new ResponseStructure<Traveller>();
			
			traveller=service.saveTraveller(traveller);
			
			responseStructure.setCode(HttpStatus.CREATED.value());
			
			responseStructure.setMessage("CREATED");
			
			responseStructure.setData(traveller);
			
			
			return new ResponseEntity<ResponseStructure<Traveller>>(responseStructure,HttpStatus.OK);
		
		}else {
			 throw new TravellerNotSavedException("NULL VALUES ARE NOT ACCEPTED");
		}
		
	}
	
	
	@PutMapping("/traveller")
	public ResponseEntity<ResponseStructure<Traveller>> updateTraveller(@RequestBody  Traveller traveller) {
		
		if(traveller==null) {
			
			traveller=service.updateTraveller(traveller);
			ResponseStructure<Traveller> responseStructure=new ResponseStructure<Traveller>();
			
			responseStructure.setCode(HttpStatus.ACCEPTED.value());
			
			responseStructure.setMessage("update Sucessfully");
			
			responseStructure.setData(traveller);
			return new ResponseEntity<ResponseStructure<Traveller>>(responseStructure,HttpStatus.OK);
		}else {
			throw new TravellerNotUpdateException("NULL VALUES ARE NOT ACCEPTED");
		}
	}
	
	@GetMapping("/traveller/{id}")
	public ResponseEntity<ResponseStructure<Traveller>> getOneTraveller1(@PathVariable int id) {
		if(id==1) {
		Traveller traveller=service.getOneTraveller(id);
//		fetch country of the above traveller from country service
//		http://localhost:8082/traveller/1
		
		
//	List<Country> countryOfTraveller1=restTemplate.getForObject("http://COUNTRY/traveller/"+traveller.getTravellerId(),ArrayList.class);

//		Traveller With All Country
	List<Country> countries=servicess.getAllcountries();
    traveller.setCountries(countries);
	
	
//	Country[] countryOfTraveller=restTemplate.getForObject("http://COUNTRY/traveller/"+traveller.getTravellerId(),Country[].class);

//	List<Country> countryOfTraveller=servicess.getAllcountries();
	
//	City city=cityService.getOneCitys(country.getCityId());
//	List<Country> countries1=Arrays.stream(countryOfTraveller).toList();
	
//	List<Country> countries2= countries1.stream().map(country->{
		

//	 countryOfTraveller.stream().map(country->{
//		
//		City city=cityService.getOneCity(id);
//		 
//		country.setCity(city);
//		return  country;
//	}).collect(Collectors.toList());
//	
	
//	logger.info("{}",countryOfTraveller1);
		
		
	
		
//		System.out.println(traveller);
//     
   
     
//     country.setCity(city);
     
//     countryOfTraveller.add(country);
//     traveller.setCountries(countryOfTraveller);
		
//		One Traveller With One Country And City
		
//		Country country=servicess.getCountry(id);
//	
//       List<Country> countries=new ArrayList<Country>();
//       
//       countries.add(country);
//       
//     traveller.setCountries(countries);
		
		
//		traveller.setCountries(countrieList);
		
		
//	traveller.setCountries(traveller2);
	
	
		
		ResponseStructure<Traveller> responseStructure=new ResponseStructure<Traveller>();
		
		responseStructure.setCode(HttpStatus.FOUND.value());
		
		responseStructure.setMessage("FOUND");
		
		responseStructure.setData(traveller);
//		responseStructure.setData(traveller2);
		
		return  new ResponseEntity<ResponseStructure<Traveller>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new TravellerNotFoundException("Traveller Not Found with ID:"+" "+id);
		}
	}
	

	

	
	
	
//	@SuppressWarnings("unchecked")
//	@GetMapping("/traveller/{id}")
//	public Traveller getOneTraveller(@PathVariable int id) {
//		
//		Traveller traveller=service.getOneTraveller(id);
////		fetch country of the above traveller from country service
////		http://localhost:8082/traveller/1
//		
//	List<Country> countryOfTraveller=restTemplate.getForObject("http://localhost:8082/traveller/1",ArrayList.class);
//		
//		logger.info("{} ",countryOfTraveller);
//		
//		traveller.setCountries(countryOfTraveller);
//		
//		
//		return  traveller;
//		}
	
	
	
	
	
	@GetMapping("/traveller")
	@ResponseBody
	public ResponseEntity<ResponseStructure<List<Traveller>>> getAll(){
List<Traveller> travellers=service.getAll();
		
if(travellers!=null && !travellers.isEmpty()) {
		ResponseStructure<List<Traveller>> responseStructure=new ResponseStructure<>();
		
		responseStructure.setCode(HttpStatus.FOUND.value());
		
		responseStructure.setData(travellers);
		
		responseStructure.setMessage("found");
		
		return new ResponseEntity<ResponseStructure<List<Traveller>>>(responseStructure,HttpStatus.FOUND);
}else {
	
	throw new TravellerListNotFoundException("NO TRAVELLERS ARE AVAILABLE");
}
		
	}	
	
	
	
//	@DeleteMapping("/traveller")
//	public boolean deleteTraveller(Traveller traveller) {
//		
//		return service.deleteTraveller(traveller);
//	}
	
	
	@DeleteMapping("/traveller/{id}")
	public ResponseEntity<ResponseStructure<Traveller>> deleteByTraveller(@PathVariable int id) {
		
		Traveller traveller=service.deleteTravellerWithId(id);
		
		if(traveller!=null) {
		ResponseStructure<Traveller> responseStructure=new ResponseStructure<Traveller>();
		
		responseStructure.setCode(HttpStatus.NO_CONTENT.value());
		
		responseStructure.setMessage("NOT CONTENT");
		
		responseStructure.setData(traveller);
		
		
		return new ResponseEntity<ResponseStructure<Traveller>>(responseStructure,HttpStatus.NO_CONTENT);
		
		}else {
			
			ResponseStructure<Traveller> responseStructure=new ResponseStructure<Traveller>();
			
			responseStructure.setCode(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("NOT FOUND");
			
			responseStructure.setData(traveller);
			
			
			return new ResponseEntity<ResponseStructure<Traveller>>(responseStructure,HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	
//	 

	
	
	
}
