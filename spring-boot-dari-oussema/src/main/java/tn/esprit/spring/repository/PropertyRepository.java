package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;

@Repository
public interface PropertyRepository  extends CrudRepository<Property, Long> {


		@Query(
				  value = "SELECT * FROM property v WHERE v.id= ?1", 
				  nativeQuery = true)
		
		Property findHouseById(Long id);
		
		List<Property> findByName(String nom);
	
	}
