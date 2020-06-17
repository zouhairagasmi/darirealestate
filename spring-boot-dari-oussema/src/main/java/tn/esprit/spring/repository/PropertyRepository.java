package tn.esprit.spring.repository;

import java.util.Date;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Property;

@Repository
public interface PropertyRepository  extends CrudRepository<Property, Long> {


		@Query(
				  value = "SELECT * FROM property v WHERE v.id= ?1", 
				  nativeQuery = true)
		
		Property findHouseById(Long id);
		
		List<Property> findByName(String nom);
		
		
	}