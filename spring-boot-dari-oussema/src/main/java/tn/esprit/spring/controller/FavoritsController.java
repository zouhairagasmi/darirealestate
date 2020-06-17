package tn.esprit.spring.controller;

import java.util.Date;


import java.util.List;



import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.Property;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IFavoritsService;
import tn.esprit.spring.service.IUserService;

@Scope(value = "session")
@Controller(value = "favoritsController")
@ELBeanName(value = "favoritsController")
public class FavoritsController {

	@Autowired
	IFavoritsService ifavservice;

	private Long id;

	private User user;

	private Property property;

	private Date date;


	private List<Favorits> favorits;

	private IUserService iUserService;

	private User Current = UserJsfController.user;
	
	//working
	public void deleteFav(long id) {
		ifavservice.deleteFavorit(id);
	}

	public void displayitem(Favorits i) {

	}



	
	public List<Favorits> getFavorits() {
		favorits = ifavservice.findByuserId(Current.getIdU());
		return favorits;
	}
	
//	public List<Favorits> getFavorits() {
//		favorits = ifavservice.findByUserr(Curruent);
//		return favorits;
//	}
	
	public void addfav(Property prop) {
		
		ifavservice.addFavorit(new Favorits(Current,prop));
	}
	
	
//	public void additem() {
//		itemservice.addNewItem(new Item(Current,itemName,description,price,availableQuantity,location,pic,shippingWeight,category));
//	}


	public User getCurrent() {
		return Current;
	}

	public void setCurrent(User current) {
		Current = current;
	}

	public IFavoritsService getIfavservice() {
		return ifavservice;
	}

	public void setIfavservice(IFavoritsService ifavservice) {
		this.ifavservice = ifavservice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public void setFavorits(List<Favorits> favorits) {
		this.favorits = favorits;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}
	


	
	
}
