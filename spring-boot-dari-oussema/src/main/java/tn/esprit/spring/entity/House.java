package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="House")
public class House {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdHouse;
	
	@OneToMany
	private List<Visits> Visits = new ArrayList<>();
	
	@ManyToOne
	private User Owner;
	
	private Double price;
	
	@Temporal(TemporalType.DATE)
	private Date DateVisitDebut;
	
	@Temporal(TemporalType.DATE)
	private Date DateVisitFin;
	
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(Long idHouse, User owner, Double price,Date dateVisitDebut, Date dateVisitFin) {
		super();
		IdHouse = idHouse;
		Owner = owner;
		this.price = price;
		DateVisitDebut = dateVisitDebut;
		DateVisitFin = dateVisitFin;
	}

	public Long getIdHouse() {
		return IdHouse;
	}
	public void setIdHouse(Long idHouse) {
		IdHouse = idHouse;
	}
	
	public List<Visits> getVisits() {
		return Visits;
	}
	public void setVisits(List<Visits> visits) {
		Visits = visits;
	}
	public User getOwner() {
		return Owner;
	}
	public void setOwner(User owner) {
		Owner = owner;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateVisitDebut() {
		return DateVisitDebut;
	}
	public void setDateVisitDebut(Date dateVisitDebut) {
		DateVisitDebut = dateVisitDebut;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateVisitFin() {
		return DateVisitFin;
	}
	public void setDateVisitFin(Date dateVisitFin) {
		DateVisitFin = dateVisitFin;
	}
}
