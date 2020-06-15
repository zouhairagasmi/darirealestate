package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class InsuranceUserPK implements Serializable {
	private static final long serialVersionUID = 6191889143079520027L;
	
	private int idI;
	
	private int idU;
	
	//Choisir le TemporalType selon le besoin metier
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfInscription;

	public int getIdI() {
		return idI;
	}

	public void setIdI(int idI) {
		this.idI = idI;
	}

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}

	public Date getDateOfInscription() {
		return dateOfInscription;
	}

	public void setDateOfInscription(Date dateOfInscription) {
		this.dateOfInscription = dateOfInscription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfInscription == null) ? 0 : dateOfInscription.hashCode());
		result = prime * result + idI;
		result = prime * result + idU;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsuranceUserPK other = (InsuranceUserPK) obj;
		if (dateOfInscription == null) {
			if (other.dateOfInscription != null)
				return false;
		} else if (!dateOfInscription.equals(other.dateOfInscription))
			return false;
		if (idI != other.idI)
			return false;
		if (idU != other.idU)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InsuranceUserPK [idI=" + idI + ", idU=" + idU + ", dateOfInscription=" + dateOfInscription + "]";
	}

	public InsuranceUserPK(int idI, int idU, Date dateOfInscription) {
		super();
		this.idI = idI;
		this.idU = idU;
		this.dateOfInscription = dateOfInscription;
	}

	public InsuranceUserPK() {
		super();
	}
	
	
}
