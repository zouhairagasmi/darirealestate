package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Claim {
	public Claim(Long idClaim, String status, String type, String description) {
		super();
		this.idClaim = idClaim;
		this.status = status;
		this.type = type;
		this.description = description;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClaim;
	
	@Column
	private String status;

	@Column
	private String type;
	@Column
	private String description;
	public Long getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Claim(String description, String status, String type) {
		super();
		this.description = description;
		this.status = status;
		this.type = type;

	}


	
	public Claim() {
		super();


	}
	
	

}
