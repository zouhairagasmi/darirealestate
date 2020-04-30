package tn.esprit.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Visits")
public class Visits {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdVisit;
	
	@ManyToMany
	private List<User> users;
	
	@ManyToOne
	private House Property;
	
	@Temporal(TemporalType.DATE)
	private Date DateVisit;

	public Visits() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Visits(Long idVisit, House property, Date dateVisit) {
		super();
		this.IdVisit = idVisit;
		Property = property;
		DateVisit = dateVisit;
	}

	
	//public Visits(Long idVisit, User currentuser, House property, Date dateVisit) {
		//super();
		//IdVisit = idVisit;
		//users.set(0, House.getOwner());
		//users.set(1, currentuser);
		//Property = property;
		//DateVisit = dateVisit;}


	public Long getIdVisit() {
		return IdVisit;
	}

	public void setIdVisit(Long idVisit) {
		IdVisit = idVisit;
	}

	public House getProperty() {
		return Property;
	}

	public void setProperty(House property) {
		Property = property;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateVisit() {
		return DateVisit;
	}

	public void setDateVisit(Date dateVisit) {
		DateVisit = dateVisit;
	}

		
	
	
}
