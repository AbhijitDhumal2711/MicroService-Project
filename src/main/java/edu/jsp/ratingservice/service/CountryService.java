package edu.jsp.ratingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.ratingservice.dto.Country;
import edu.jsp.ratingservice.repos.CountryRepos;

@Service
public class CountryService {

	

	@Autowired
	
	private CountryRepos countryRepos;
	
	
	
	
	
	
	public Country  saveCountry(Country country) {
		
		return countryRepos.save(country);
	}
	
	
//Traveller Id
       public List<Country>  saveCountrys(int travellerId) {
		
		return countryRepos.findByTravellerId(travellerId);
	}

       
//       CityId
    public List<Country>  saveCountrys2(int cityId) {
	
	return countryRepos.findByCityId(cityId);
}
	
	
	
	public List<Country> getAllCountry() {
		
		return countryRepos.findAll();
	}
	
	
	
	public Country getOneCountry(int id) {
		
		return countryRepos.findById(id).get();
	}
	
	
	public Country updateCountry(Country country) {
		
		return countryRepos.save(country);
	}
	
	
	
	public boolean deleteCountryById( int countryId) {
		
		try {
			
			countryRepos.deleteById(countryId);
			
			return true;
			
			
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
		
		
	}

	public Country deleteCountryWithId(int id) {
		
        
		return countryRepos.deleteById(id);	
		
	}
	
	
}
