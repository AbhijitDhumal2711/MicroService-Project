package edu.jsp.userservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.userservice.dto.Traveller;

@Repository
public interface TravellerRepos extends JpaRepository<Traveller, Integer> {

	public Traveller deleteById(int id);
	
	
}
