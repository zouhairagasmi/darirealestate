package tn.esprit.spring.interfaces;

import java.util.Date;

import java.util.List;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Property;


public interface IReservationService {
	
    /* Basic CRUD operations */
	List<Reservation> findOneByPropertyAndDates(Long id, Long PId, Date from, Date to);
    List<Reservation> findAllByUserAndPropert(User user, Property property);
    Reservation findByIdd(Long id);
    Reservation save(Reservation reservation);
     void deleteRes(Long id);
     Reservation updateRes(Reservation res);
     List<Reservation> getAllReservations();
     List<Reservation> findAllReservationByUser(int UId);

}
