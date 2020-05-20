package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vues implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int idVues;
	private int nbrVues;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private Property property;
	

	public Vues() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdVues() {
		return idVues;
	}

	public void setIdVues(int idVues) {
		this.idVues = idVues;
	}

	public int getNbrVues() {
		return nbrVues;
	}

	public void setNbrVues(int nbrVues) {
		this.nbrVues = nbrVues;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	

	
	
	

}
