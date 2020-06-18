package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long>{
@Query("select p from Claim p where p.id=:id")
	Claim getClaimById(@Param("id")Long id);	
	
	
	  @Transactional
	    @Modifying
	    @Query("update Claim u set u.description = ?1, u.status = ?2, u.type = ?3 where u.idClaim = ?4")
	    void updateClaimById(String description, String status, String type , Long idClaim);
	  	

}
