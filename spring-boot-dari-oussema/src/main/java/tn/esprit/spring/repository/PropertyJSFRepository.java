package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;



public interface PropertyJSFRepository extends CrudRepository<Property, Long>{

	@Query("select e from Property e "
			+ "where e.id=:id ")
	public List<Property> findAllById(@Param("id") Long id);
	
	@Query("select e from Property e "
			+ "where e.name=:name ")
	public List<Property> findAllByName(@Param("name") String name);
	 
/*
	/*@Query("Select DISTINCT p from Property p "
			+ "join Location l "
			+ "on  p.id = l.id " )
	public List<Property> getPropertyWithLocation();
	*/
	
	@Query("Select emp from Property emp "
			+ "where emp.buildingType=:buildingType and "
			+ "emp.serviceType=:serviceType and emp.town=:town")
    public List<Property> getAllPropertyByBuildingTypeEtServiceType(@Param("buildingType") BuildingType buildingType,@Param("serviceType") ServiceType serviceType,@Param("town") String town);
}
