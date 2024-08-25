package edu.jsp.userservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.jsp.userservice.dto.City;
import edu.jsp.userservice.dto.Country;
import edu.jsp.userservice.dto.Traveller;

@FeignClient(name="COUNTRY")
public interface CountryServicess {

	@GetMapping("/country/{countryId}")
   public Country getCountry(@PathVariable("countryId") int countryId);
	
	@GetMapping("country")
	public List<Country> getAllcountries();
	

}
