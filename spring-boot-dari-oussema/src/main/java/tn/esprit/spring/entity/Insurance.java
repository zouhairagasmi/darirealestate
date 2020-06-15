package tn.esprit.spring.entity;





import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Assurance")
public class Insurance implements Serializable {
	private static final long serialVersionUID = 6191889143079529027L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idI;
	private String title;
	private String description;
	private String agencyName;
	private String agencyAdress;
	public Long getIdI() {
		return idI;
	}
	public void setIdI(Long idI) {
		this.idI = idI;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAgencyAdress() {
		return agencyAdress;
	}
	public void setAgencyAdress(String agencyAdress) {
		this.agencyAdress = agencyAdress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencyAdress == null) ? 0 : agencyAdress.hashCode());
		result = prime * result + ((agencyName == null) ? 0 : agencyName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idI == null) ? 0 : idI.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Insurance other = (Insurance) obj;
		if (agencyAdress == null) {
			if (other.agencyAdress != null)
				return false;
		} else if (!agencyAdress.equals(other.agencyAdress))
			return false;
		if (agencyName == null) {
			if (other.agencyName != null)
				return false;
		} else if (!agencyName.equals(other.agencyName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idI == null) {
			if (other.idI != null)
				return false;
		} else if (!idI.equals(other.idI))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Insurance [idI=" + idI + ", title=" + title + ", description=" + description + ", agencyName="
				+ agencyName + ", agencyAdress=" + agencyAdress + "]";
	}
	public Insurance(Long idI, String title, String description, String agencyName, String agencyAdress) {
		super();
		this.idI = idI;
		this.title = title;
		this.description = description;
		this.agencyName = agencyName;
		this.agencyAdress = agencyAdress;
	}
	public Insurance() {
		super();
	}
	
}
