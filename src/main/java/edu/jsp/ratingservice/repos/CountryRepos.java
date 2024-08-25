package edu.jsp.ratingservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ratingservice.dto.Country;


@Repository
public interface CountryRepos extends JpaRepository<Country, Integer> {

	
	List<Country> findByTravellerId(int travellerId);
	
	List<Country> findByCityId(int cityId);
	
	public Country deleteById(int id);
	
}
