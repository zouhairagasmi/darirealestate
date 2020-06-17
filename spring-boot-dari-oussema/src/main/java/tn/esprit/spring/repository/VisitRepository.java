package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.Visits;

@Repository
public interface VisitRepository extends JpaRepository<Visits, Long>{

	
	
	

	
	@Transactional
    @Modifying
	@Query("update Visits u set u.dateVisit = ?1 where u.id = ?2")
	void updateVisitById(Date dateVisit, Long idVisit);
	
	@Query(
			  value = "SELECT * FROM Visits v WHERE v.visitor_idu= ?1", 
			  nativeQuery = true)
	List<Visits> findVisitByIdVisitor(Long userId);
	
    //@Query("update Visits u set u.DateVisit = ?1 where u.id_visit = ?2")
    //void updateVisitById(Date date , Long idV);
  
	//@Query("select u from house u where u.id=:id")
	//House getHouseByiddd(@Param("id")Long id);
	
	 @Query(
			  value = "SELECT * FROM Visits v WHERE v.visitor_idu= ?1", 
			  nativeQuery = true)
			List<Visits> findViByIdUser(Long userId);
}