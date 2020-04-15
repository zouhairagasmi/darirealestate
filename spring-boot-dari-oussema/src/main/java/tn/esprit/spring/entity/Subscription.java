package tn.esprit.spring.entity;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Abonnement")
public class Subscription {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idS;
	private String description;
	private String name;
	private float price;
	
	
	@OneToMany(mappedBy="subscription")
	private List<User> users;


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


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Subscription() {
		super();
	}


	public Subscription(Long idS, String description, String name, float price, List<User> users) {
		super();
		this.idS = idS;
		this.description = description;
		this.name = name;
		this.price = price;
		this.users = users;
	}


	public Subscription(Long idS) {
		super();
		this.idS = idS;
	}

	
	
}
