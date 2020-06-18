package tn.esprit.spring.service;

import java.util.Date;

import java.util.List;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Property;


public interface IReservationService {
	
    /* Basic CRUD operations */
//	List<Reservation> findOneByPropertyAndDates(Long id, Long PId, Date from, Date to);
//    List<Reservation> findAllByUserAndProperty(User user, Property property);
    Reservation findByIdd(Long id);
    Reservation save(Reservation reservation);
     void deleteRes(Long id);
     Reservation updateRes(Reservation res);
     List<Reservation> getAllReservations();
//     List<Reservation> findAllReservationByUser(int UId);
	 public  String save();
	 public Reservation getReservation();
	 public String delete(Long id);
	 public String modifier(Reservation p, Date datefrom, Date dateto);
	 public void loadData();
	 public List<Reservation> getReservations();
	 public String saveModif();
	 public void cancelres(Long id);
	 public Double costReservation(Long id);
	 


}
