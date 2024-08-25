package edu.jsp.ratingservice.serviceinter;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.jsp.ratingservice.dto.City;

@FeignClient(name = "CITY")
public interface CityService {

	@GetMapping("city/{cityId}")
	public City getCity(@PathVariable("cityId") int cityId);
	
	@GetMapping("city")
	public List<City> getAllCity();
	
}
