package edu.jsp.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.userservice.dto.Traveller;
import edu.jsp.userservice.repos.TravellerRepos;


@Service
public class TravellerService {

	
	@Autowired
	
	private TravellerRepos repos;
	
	
public Traveller saveTraveller(Traveller traveller) {
		
		return repos.save(traveller);
	}
	
	public Traveller getOneTraveller(int id) {
		return repos.findById(id).get();
	}
	
	public List<Traveller> getAll(){
		
		return repos.findAll();
	}
	
	public Traveller updateTraveller(Traveller traveller) {
		
		return repos.save(traveller);
	}
	
	public Traveller deleteTravellerWithId(int id) {
		
	        
		return repos.deleteById(id);	
		
	}
	
	
	
	public boolean deleteById(int id) {
		
		
		try {
			
			repos.deleteById(id);
			
			return true;
			
			
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
		
		
	}

	
	
	
	
	
}
