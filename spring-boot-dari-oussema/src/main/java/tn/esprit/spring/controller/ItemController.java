package tn.esprit.spring.controller;

import java.io.InputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
import tn.esprit.spring.service.UploadHelper;


@Scope(value = "session")
@Controller(value = "itemController")
@ELBeanName(value = "itemController")
public class ItemController{
	@Autowired
	ItemServiceInterface itemservice;
	private User Current = UserJsfController.user;
	private String itemName;
	private Double price;
	private int availableQuantity;
	private Double shippingWeight;
	private Category category;
	public Category[] getCategories() { return Category.values(); }	
	private String description;
	private List<Item> items;
	private long idtobeupdated;
	private String location;
	private String pic;

	public void additem() {
		itemservice.addNewItem(new Item(Current,itemName,description,price,availableQuantity,location,pic,shippingWeight,category));
	}
	public void deleteitem(long id){
		itemservice.deleteItem(id);
	}
	public void displayitem(Item i){
		this.setCurrent(i.getUser());
		this.setAvailableQuantity(i.getAvailableQuantity());
		this.setCategory(i.getCategory());
		this.setDescription(i.getDescription());
		this.setIdtobeupdated(i.getItemId());
		this.setItemName(i.getItemName());
		this.setPrice(i.getPrice());
		this.setShippingWeight(i.getShippingWeight());
		this.setPic(i.getPic());
	}
	public void updateitem() {
		itemservice.addNewItem(new Item(idtobeupdated,Current,itemName,description,price,availableQuantity,location,pic,shippingWeight,category));
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
	public List<Item> getItems() {
		return itemservice.getAllItems();
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public long getIdtobeupdated() {
		return idtobeupdated;
	}
	public void setIdtobeupdated(long idtobeupdated) {
		this.idtobeupdated = idtobeupdated;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
}