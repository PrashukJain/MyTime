package com.nagarro.tables.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.tables.entity.AirportInfo;
@Repository
public interface AirportInfoRepository extends JpaRepository<AirportInfo, Long>{
	
	@Query("Select distinct u.city from AirportInfo as u order by  u.city asc")
List<String> allCities();
	
	@Query("Select distinct u.country from AirportInfo as u order by  u.country asc")
	List<String> allCountries();
	
	@Query("Select  u from AirportInfo as u where u.city=:param order by  u.city asc")
	List<AirportInfo> getByCity(String param);
	
	@Query("Select  u from AirportInfo as u where u.country=:param order by  u.country asc")
	List<AirportInfo> getByCountry(String param);
}
