package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;


@Repository
public interface PropertyRepository extends CrudRepository< Property, Long >{
	
	@Query("Select emp from Property emp "
			+ "where emp.buildingType=:buildingType and "
			+ "emp.serviceType=:serviceType ")
    public List<Property> getAllPropertyByBuildingTypeEtServiceType(@Param("buildingType") BuildingType buildingType,@Param("serviceType") ServiceType serviceType);
/*
	@Query("Select p from Property p "
			+ "join Location l "
			+ "on  p.id = l.id "
			+ "where l.latitude <=:lat AND l.longitude <=:lng" )
	public List<Property> getNearstLocation(@Param("lat") Double latitude,@Param("lng") Double longitude);*/
	
	/*
	@Query("SELECT " + 
			"(" + 
			"   3959 *" + 
			"   acos(cos(radians(37)) * " + 
			"   cos(radians(lat)) * " + 
			"   cos(radians(lng) -" + 
			"   radians(-122)) + " + 
			"   sin(radians(37)) * " + 
			"   sin(radians(lat )))" + 
			") "
			+ "AS distance " + 
			"FROM Location " + 
			"HAVING distance < 28 " + 
			"ORDER BY distance LIMIT 0, 20")*/
	
	/*@Query("SELECT DISTINCT FROM Location "
			+ " WHERE (Lat + lng ) <= 1000")
			
			
			Select  DISTINCT m from Property m "
			+ "join Location e "
			+ "Where e.latitude<=:lat+100"
			+ "And e.longitude<=:lng+100
			
			*
			*/
	
}
