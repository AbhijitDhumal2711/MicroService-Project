package edu.jsp.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.jsp.userservice.dto.City;


@FeignClient(name="CITY")
public interface CityService {

	@GetMapping("/city/{cityId}")
	public City getOneCitys(@PathVariable("cityId") int cityId);
	
}
