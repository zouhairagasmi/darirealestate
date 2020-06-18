package tn.esprit.spring.controller;

import java.util.Date;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IFavoritsService;
import tn.esprit.spring.service.IPropertyzService;
import tn.esprit.spring.service.IReservationService;
import tn.esprit.spring.service.IUserService;

@Scope(value = "session")
@Controller(value = "reservationController")
@ELBeanName(value = "reservationController")
public class ReservationController {
	
	@Autowired
	IReservationService iresservice;
	@Autowired
	IUserService iuserservice;
	@Autowired
	IPropertyzService iHouseService;

	private Long id;

	private User user;

	private Property property;

	private Date datefrom;

	private Date dateto;
	
	private boolean cancelled = false;
	double coast ;
	
//	long d = (long) 1;
//	
//	private Property reserved = iHouseService.findByIdd(d);
	

	private List<Reservation> reservations;
	
	
	
//	public String AddRes(){
//		String navigateTo="null";
//		Reservation v = new Reservation(id, iuserservice.getUserById(UserJsfController.iduser),reserved,datefrom,dateto,cancelled);
//		iresservice.save(v);
//		navigateTo = "/main.xhtml?faces-redirect=true";
//		return navigateTo;
//	}
	
	
	public List<Reservation> getReservations() {
		reservations = iresservice.getAllReservations();
		return reservations;
	}
	
	public Double costres(long id) {
		return iresservice.costReservation(id);
		}
	
	public void deleteres(long id) {
		iresservice.deleteRes(id);
	}
	
	public void cancelres(Long idd) {
		iresservice.cancelres(idd);
		
	}
	

	public IReservationService getIresservice() {
		return iresservice;
	}

	public void setIresservice(IReservationService iresservice) {
		this.iresservice = iresservice;
	}
	
	

//	public long getD() {
//		return d;
//	}
//
//
//	public void setD(long d) {
//		this.d = d;
//	}
//
//
//	public Property getReserved() {
//		return reserved;
//	}
//
//
//	public void setReserved(Property reserved) {
//		this.reserved = reserved;
//	}


	public IUserService getIuserservice() {
		return iuserservice;
	}


	public void setIuserservice(IUserService iuserservice) {
		this.iuserservice = iuserservice;
	}


	public IPropertyzService getiHouseService() {
		return iHouseService;
	}


	public void setiHouseService(IPropertyzService iHouseService) {
		this.iHouseService = iHouseService;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	
	public double getCoast() {
		return coast;
	}

	public void setCoast(double coast) {
		this.coast = coast;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}

	public Date getDateto() {
		return dateto;
	}

	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}



	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
}
