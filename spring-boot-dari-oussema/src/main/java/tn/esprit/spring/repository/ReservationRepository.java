package tn.esprit.spring.repository;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Property;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
	    List<Reservation> findOneByPropertyAndDates(@Param("id") Long id, @Param("property") Long PId, @Param("fr") Date datefrom, @Param("to") Date dateto);
	    List<Reservation> findAllByUserAndPropert(User user, Property property);

}
