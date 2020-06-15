package tn.esprit.spring.controller;



import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.interfaces.ISubscriptionService;




@Scope(value = "session")
@Controller(value = "subscriptionController")
@ELBeanName(value = "subscriptionController")
@Join(path = "/", to = "/loginn.jsf")
public class SubscriptionController {
	
	@Autowired
	ISubscriptionService iSubscriptionService;
	
	private Long idS;
	private String description;
	private String name;
	private float price;
	private List<Subscription> subscriptions;
	
	
	
	public Long getIdS() {
		return idS;
	}
	public void setIdS(Long idS) {
		this.idS = idS;
	}
	public List<Subscription> getSubscriptions() {
		subscriptions = iSubscriptionService.getAllSubscriptions();
		return subscriptions;
		
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	public ISubscriptionService getiSubscriptionService() {
		return iSubscriptionService;
	}
	public void setiSubscriptionService(ISubscriptionService iSubscriptionService) {
		this.iSubscriptionService = iSubscriptionService;
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
	
	

}
