package tn.esprit.spring.service;



import java.util.Date;


import java.util.List;


import tn.esprit.spring.entity.Reservation;

import tn.esprit.spring.service.IReservationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.repository.ReservationRepository;


@Service
public class ReservationService implements IReservationService {
	
	private static final String idd = null;
    
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	    private ReservationRepository reservationRepository;




	    
	    @Override
	    public List<Reservation> getAllReservations() {
	    	return (List<Reservation>)reservationRepository.findAll();
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
	    
//	    @Override
//	    public List<Reservation> findAllReservationByUser(int UId) {
//			return reservationRepository.findAllReservationByUser(UId);
//		}

	    
	    
	    private Reservation reservation = new Reservation();
		private List<Reservation> reservations;


		@Override
		public String save() {
			reservationRepository.save(reservation);
			reservation = new Reservation();
			return "/reservation-list.xhtml?faces-redirect=true";
		}

		@Override
		public Reservation getReservation() {

			return reservation;
		}

		@Override
		public String delete(Long id) {
			Reservation p =reservationRepository.findById(id).get();
			reservationRepository.delete(p);
			return "/reservation-list.xhtml?faces-redirect=true";
		}

		@Override
		public String modifier(Reservation p, Date datefrom, Date dateto) {
			reservation=p;
			return "/reservation-form-modif.xhtml?faces-redirect=true";


		}

		@Override
		public void loadData() {
			reservations = (List<Reservation>) reservationRepository.findAll();

		}

		@Override
		public List<Reservation> getReservations() {
			return reservations;
		}


		@Override
		public String saveModif() {
			Reservation p1=reservationRepository.findById(reservation.getId()).get();
			p1.setDatefrom(reservation.getDatefrom());
			p1.setDateto(reservation.getDateto());
			reservationRepository.save(p1);
			reservation = new Reservation();
			return "/reservation-list.xhtml?faces-redirect=true";
		}


		@Override
		public void cancelres(Long idd) {
			Reservation res = reservationRepository.findById(idd).get();
			res.setCancelled(true);
			reservationRepository.save(res);
			
		}


		@Override
		public Double costReservation(Long id) {
			Reservation res = reservationRepository.findById(id).get();
		//	int d1= res.getDateto().getDay();
			long duration = res.getDateto().getTime() - res.getDatefrom().getTime();
			double diffInDays = (int) duration / (1000 * 60 * 60 * 24);
			Double cost = res.getProperty().getPrice() * diffInDays ;
			return cost;
		}


		
		    
	    
	    
	    
	}

