package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

	 @Transactional
	    @Modifying
	    @Query("update Property u set u.name = ?1, u.price = ?2, u.description = ?3, u.province= ?4, u.town= ?5 ,u.numberBedroom= ?6 ,u.numberWc= ?7, u.furnished= ?8 , u.garage = ?9, u.pool=?10, u.ac=?11, u.heating=?12, u.elevator=?13, u.neartransport=?14, u.storage=?15, u.office=?16, u.terrace=?17 where u.id = ?18")
	    void updatePropertyById(String name, Double price, String description, String province, String town, Integer numberBedroom , Integer numberWc,Boolean furnished,Boolean garage,Boolean pool,Boolean ac,Boolean heating,Boolean elevator,Boolean neartransport,Boolean storage,Boolean office,Boolean terrace, Long id);

}
