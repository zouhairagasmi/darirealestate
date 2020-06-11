package tn.esprit.spring.service;

import java.util.Date;

import java.util.List;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IReservationService;
import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.Property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.ReservationRepository;


@Service
public class ReservationService implements IReservationService {
	
	private static final String idd = null;
	
	    private ReservationRepository reservationRepository;

	    @Autowired
	    public void setReservationRepository(ReservationRepository reservationRepository) {
	        this.reservationRepository = reservationRepository;
	    }
	    
	    @Override
	    public List<Reservation> getAllReservations() {
	    	return (List<Reservation>)reservationRepository.findAll();
	    }

	    @Override
	    public List<Reservation> findOneByPropertyAndDates(Long id, Long PId, Date from, Date to) {
	        return reservationRepository.findOneByPropertyAndDates(id, PId, from, to);
	    }

	    @Override
	    public List<Reservation> findAllByUserAndPropert(User user, Property property){
	        return reservationRepository.findAllByUserAndPropert(user, property);
	    }

	    @Override
	    public Reservation findByIdd(Long id) {
	    	Reservation res = reservationRepository.findById(id).get();
	    	return res;
	    }

	    @Override
	    public Reservation save(Reservation reservation) {
	        return reservationRepository.save(reservation);
	    }

	    @Override
	    public void deleteRes(Long id) {
	    	reservationRepository.deleteById(id);
	    }
	    
	    @Override
	    public Reservation updateRes(Reservation res) {
	    	Reservation res1 = reservationRepository.findById(res.getId()).get();
	    	res1.setDatefrom(res.getDatefrom());
	    	res1.setDateto(res.getDateto());
	    	reservationRepository.save(res1);
	    	return res1;
	    }
	    
	    @Override
	    public List<Reservation> findAllReservationByUser(int UId) {
			return reservationRepository.findAllReservationByUser(UId);
		}
	}

