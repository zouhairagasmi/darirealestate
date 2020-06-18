package tn.esprit.spring.repository;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Property;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
//	    List<Reservation> findOneByPropertyAndDates(@Param("id") Long id, @Param("property") Long PId, @Param("fr") Date datefrom, @Param("to") Date dateto);
//	    List<Reservation> findAllByUserAndProperty(User user, Property property);
//	    @Query("select DISTINCT m from reservation m join m.user e where e.id=:UId")
//		public List<Reservation> findAllReservationByUser(@Param("UId")int UId);
	

 
	 @Modifying
	    @Transactional
	    @Query("UPDATE Reservation e SET e.cancelled=: true where e.id=:idd")
	    public void CancelRes(@Param("idd")Long idd);
}
