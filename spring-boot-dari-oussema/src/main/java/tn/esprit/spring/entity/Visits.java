package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="Visits")
public class Visits {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVisit;
	
	@ManyToOne
	private User visitor;
	
	@ManyToOne
	private House property;
	
	@Temporal(TemporalType.DATE)
	private Date dateVisit;

	@Enumerated(EnumType.STRING)
	private VisitType visitType;
	
	public Visits() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Visits(House house, Date date) {
		super();
		property = house;
		dateVisit = date;
	}


	public Visits(Long id, House house, Date date) {
		super();
		this.idVisit = id;
		property = house;
		dateVisit = date;
	}

	
	public Visits(Long id, User user, House house, Date date) {
		super();
		idVisit = id;
		setVisitor(user);
		property = house;
		dateVisit = date;}
	
	

	public Visits(House property, Date dateVisit, VisitType visitType) {
		super();
		this.property = property;
		this.dateVisit = dateVisit;
		this.visitType = visitType;
	}


	public Visits(User visitor, House property, Date dateVisit, VisitType visitType) {
		super();
		this.visitor = visitor;
		this.property = property;
		this.dateVisit = dateVisit;
		this.visitType = visitType;
	}


	public Long getIdVisit() {
		return idVisit;
	}

	public void setIdVisit(Long id) {
		idVisit = id;
	}

	public House getProperty() {
		return property;
	}

	public void setProperty(House house) {
		property = house;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateVisit() {
		return dateVisit;
	}

	public void setDateVisit(Date date) {
		dateVisit = date;
	}


	public User getVisitor() {
		return visitor;
	}


	public void setVisitor(User user) {
		visitor = user;
	}


	public VisitType getVisitType() {
		return visitType;
	}


	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}

		
	
	
}
