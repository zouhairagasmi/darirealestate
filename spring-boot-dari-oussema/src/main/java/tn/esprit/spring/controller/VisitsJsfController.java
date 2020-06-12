package tn.esprit.spring.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
import tn.esprit.spring.services.IHouseService;
import tn.esprit.spring.services.IVisitService;

@Scope(value = "session")
@Controller(value = "visitJsfController")
@ELBeanName(value = "visitJsfController")
@Join(path = "/", to = "/login.jsf")
public class VisitsJsfController {
	@Autowired
	IVisitService iVisitsService;
	@Autowired
	IHouseService iHouseService;
	@Autowired
	IUserService iUserService;
	
	
	private Long idVisit;
	private Long idHouse;
	private House property;
	private House house;
	private List<House> properties;
	private Date dateVisit;
	private Visits visit;
	@Enumerated(EnumType.STRING)
	private VisitType visitType;
	@Enumerated(EnumType.STRING)
	private VisitType visitType1;
	private List<Visits> visits;
	private List<Visits> visits1;
	private List<User> users;
	private String name;
	private Double price;
	@Enumerated(EnumType.STRING)
    private BuildingType buildingType;
	private Date datePicker;
	private String dateToChange="2020-06-03";
	private String loanyear;
	private String monthlycost;

	
	public VisitsJsfController() {
		super();
		setVisit(new Visits());
	}

	
					/*Long id*/
	public String AddVisit(){
		String navigateTo="null";
		Visits v = new Visits(iUserService.getUserById(UserJsfController.iduser),iHouseService.findByIdd(idHouse),datePicker,visitType1);
		//if(!loggedIn) return "/login.xhtml";
		iVisitsService.addvisit(v);
		navigateTo = "/Client.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public void update(Visits visit) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		this.setIdVisit(visit.getIdVisit());
		this.setDateToChange(dateFormat.format(visit.getDateVisit()));
		this.setDateVisit(visit.getDateVisit());
		this.setVisitType(visit.getVisitType());
	}
	
	public void updateData(ActionEvent e) {
	      double f= ( price *1.2 ) / (Long.valueOf(loanyear)*12);
	      monthlycost=String.valueOf(f);
	      System.out.println(monthlycost);
	   }
	
	public String outcome(){
		return "/ClientPropertyDetails.jsf?faces-redirect=true";
	}
	
	public void deleteVisit(Long id) {
		iVisitsService.deleteVisit(id);
	}
	
	public void updateVisit() {
		Visits v = iVisitsService.findByIdd(idVisit);
		Date d= v.getDateVisit();
		try {
			System.out.println(d);
			d = new SimpleDateFormat("yyyy-mm-dd").parse(dateToChange);
			System.out.println(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.setDateVisit(d);
		//v.setDateVisit(dateVisit);
		v.setVisitType(visitType);
		iVisitsService.updateDateByVisitId(v);
	}
	
	public String goToHouseDetails(String param)
	{
		System.out.println("5dmet");
		//Map<String, String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//String param = parameterMap.get("parameter");
		Long id=Long.parseLong(param);
		idHouse=id;
		//System.out.println(id);
		return "/ClientPropertyDetails.jsf?faces-redirect=true";
	}
	
	public String doLogout()
	{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml?faces-redirect=true";
	}
	
	public String goVr()
	{
	return "/VRvisit.jsf?faces-redirect=true";
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
	public Long getIdVisit() {
		return idVisit;
	}

	public void setIdVisit(Long idVisit) {
		this.idVisit = idVisit;
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
	public List<Visits> getVisits1() {
		visits1=iVisitsService.findByuserId(UserJsfController.iduser);
		return visits1;
	}
	
	public void setVisits1(List<Visits> visits1) {
		this.visits1 = visits1;
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
	
	public VisitType getVisitType1() {
		return visitType1;
	}

	public void setVisitType1(VisitType visitType1) {
		this.visitType1 = visitType1;
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

	public String getDateToChange() {
		return dateToChange;
	}

	public void setDateToChange(String dateToChange) {
		this.dateToChange = dateToChange;
	}

	public List<House> getProperties() {
		properties=iHouseService.getAllHouses();
		return properties;
	}

	public void setProperties(List<House> properties) {
		this.properties = properties;
	}
	
	public House getHouseById(Long id) {
		house=iHouseService.findByIdd(id);
		return house;
	}

	public Long getIdHouse() {
		return idHouse;
	}

	public void setIdHouse(Long idHouse) {
		this.idHouse = idHouse;
	}

	public Visits getVisit() {
		return visit;
	}

	public void setVisit(Visits visit) {
		this.visit = visit;
	}



	public Date getDatePicker() {
		return datePicker;
	}



	public void setDatePicker(Date datePicker) {
		this.datePicker = datePicker;
	}


	public String getLoanyears() {
		return loanyear;
	}


	public void setLoanyears(String loanyear) {
		this.loanyear = loanyear;
	}


	public String getMonthlycost() {
		return monthlycost;
	}


	public void setMonthlycost(String monthlycost) {
		this.monthlycost = monthlycost;
	}
	
}
