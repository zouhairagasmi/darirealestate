package tn.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Item;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ItemServiceInterface;


@Scope(value = "session")
@Controller(value = "itemController")
@ELBeanName(value = "itemController")

public class ItemController {

	@Autowired
	private ItemServiceInterface itemservice;
	private User Current = UserController.user;
	private String itemName;
	private Double price;
	private int availableQuantity;
	private Double shippingWeight;
	private Category category;
	private String description;
	public void additem() {
		itemservice.addNewItem(new Item(Current,itemName,description,price,availableQuantity,shippingWeight,category));
	}
	public ItemServiceInterface getItemservice() {
		return itemservice;
	}
	public void setItemservice(ItemServiceInterface itemservice) {
		this.itemservice = itemservice;
	}
	public User getCurrent() {
		return Current;
	}
	public void setCurrent(User current) {
		Current = current;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}