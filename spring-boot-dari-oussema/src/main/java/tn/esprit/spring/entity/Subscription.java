package tn.esprit.spring.entity;







import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Abonnement")
public class Subscription  implements Serializable{
	private static final long serialVersionUID = 6191889143079520027L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idS;
	private String description;
	private String name;
	private float price;
	
	
	
	
	@OneToMany(mappedBy="subscription", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<User> users = new ArrayList<>();


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Long getIdS() {
		return idS;
	}


	public void setIdS(Long idS) {
		this.idS = idS;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}




	public Subscription() {
		super();
	}


	public Subscription(Long idS, String description, String name, float price) {
		super();
		this.idS = idS;
		this.description = description;
		this.name = name;
		this.price = price;
	
	}


	public Subscription(Long idS) {
		super();
		this.idS = idS;
	}


	public Subscription(Long idS, String description, String name, float price, List<User> users) {
		super();
		this.idS = idS;
		this.description = description;
		this.name = name;
		this.price = price;
		this.users = users;
	}

	
	
}
