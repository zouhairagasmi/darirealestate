package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.House;

public interface HouseRepository extends CrudRepository<House, Long>{
	
	@Query(
			  value = "SELECT * FROM House v WHERE v.id_house= ?1", 
			  nativeQuery = true)
	House findHouseById(Long id);
}
