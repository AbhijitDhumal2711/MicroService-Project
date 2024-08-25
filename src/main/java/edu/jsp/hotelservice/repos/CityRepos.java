package edu.jsp.hotelservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.hotelservice.dto.City;

@Repository
public interface CityRepos extends JpaRepository<City, Integer> {

}
