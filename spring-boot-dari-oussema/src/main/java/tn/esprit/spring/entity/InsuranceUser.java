package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="AssuranceUser")
public class InsuranceUser implements Serializable {
	private static final long serialVersionUID = 6191889143321520027L;
	
	@EmbeddedId
	private InsuranceUserPK insuranceUserPK;
	
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idU", insertable=false, updatable=false)
	private User user;
	
	
	
	@ManyToOne
    @JoinColumn(name = "idInsurance", referencedColumnName = "idI", insertable=false, updatable=false)
	private Insurance insurance;



	public InsuranceUserPK getInsuranceUserPK() {
		return insuranceUserPK;
	}



	public void setInsuranceUserPK(InsuranceUserPK insuranceUserPK) {
		this.insuranceUserPK = insuranceUserPK;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Insurance getInsurance() {
		return insurance;
	}



	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insurance == null) ? 0 : insurance.hashCode());
		result = prime * result + ((insuranceUserPK == null) ? 0 : insuranceUserPK.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		InsuranceUser other = (InsuranceUser) obj;
		if (insurance == null) {
			if (other.insurance != null)
				return false;
		} else if (!insurance.equals(other.insurance))
			return false;
		if (insuranceUserPK == null) {
			if (other.insuranceUserPK != null)
				return false;
		} else if (!insuranceUserPK.equals(other.insuranceUserPK))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "InsuranceUser [insuranceUserPK=" + insuranceUserPK + ", user=" + user + ", insurance=" + insurance
				+ "]";
	}



	public InsuranceUser(InsuranceUserPK insuranceUserPK, User user, Insurance insurance) {
		super();
		this.insuranceUserPK = insuranceUserPK;
		this.user = user;
		this.insurance = insurance;
	}



	public InsuranceUser() {
		super();
	}
	
	
}
