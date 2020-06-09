package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.House;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VisitType;
import tn.esprit.spring.entity.Visits;
import tn.esprit.spring.services.IVisitService;

@Scope(value = "session")
@Controller(value = "visitJsfController")
@ELBeanName(value = "visitJsfController")
@Join(path = "/", to = "/login.jsf")
public class VisitsJsfController {
	@Autowired
	IVisitService iVisitsService;
	
	private House property;
	private Date dateVisit;
	private Visits visit;
	@Enumerated(EnumType.STRING)
	private VisitType visitType;
	private List<Visits> visits;
	private List<User> users;
	private String name;
	private Double price;
	@Enumerated(EnumType.STRING)
    private BuildingType buildingType;

	
	public VisitsJsfController() {
		super();
		visit =new Visits();

	}

	public String ajouterVisit(){
		String navigateTo="null";
		//if(!loggedIn) return "/login.xhtml";
		iVisitsService.addvisit(new Visits(property,dateVisit,visitType));
		//navigateTo = "/welcome.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public void update(Visits visit) {
		this.setDateVisit(this.dateVisit);
	}
	
	
	
	public void updateVisit(Visits visit) {
		iVisitsService.updateDateByVisitId(visit);
	}
	
	public String doLogout()
	{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml?faces-redirect=true";
	}
	
	public String goVr()
	{
	return "/VRvisit.xhtml?faces-redirect=true";
	}
	
	public String goBack()
	{
	return "/Client.xhtml?faces-redirect=true";
	}
	
	public IVisitService getiVisitsService() {
		return iVisitsService;
	}
	public void setiVisitsService(IVisitService iVisitsService) {
		this.iVisitsService = iVisitsService;
	}
	public House getProperty() {
		return property;
	}
	public void setProperty(House house) {
		property = house;
	}
	public Date getDateVisit() {
		return dateVisit;
	}
	public void setDateVisit(Date date) {
		dateVisit = date;
	}
	public List<Visits> getVisits() {
		visits=iVisitsService.getAllVisits();
		return visits;
	}
	public Visits getVisitById(Long id) {
		visit=iVisitsService.findByIdd(id);
		return visit;
	}
	
	public void setVisits(List<Visits> visits) {
		this.visits = visits;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public VisitType getVisitType() {
		return visitType;
	}

	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
