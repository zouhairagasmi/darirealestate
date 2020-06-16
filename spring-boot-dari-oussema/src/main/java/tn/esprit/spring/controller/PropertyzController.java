package tn.esprit.spring.controller;


import java.util.List;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PropertyRepository;
import tn.esprit.spring.service.IPropertyzService;
import tn.esprit.spring.service.IUserService;
import tn.esprit.spring.service.UserService;

@Scope(value = "session")
@Controller(value = "propertyzController")
@ELBeanName(value = "propertyzController")
@Join(path = "/", to = "/login.jsf")
public class PropertyzController {
	
	@Autowired
	IPropertyzService iHouseService;
	@Autowired
	IUserService iUserService;
	
	
	private Long id;
	private Property property1;
	private Property property2;
	private Property house;
	private List<Property> properties;
	private List<User> users;
	private String name;
	private Double price;
	@Enumerated(EnumType.STRING)
    private BuildingType buildingType;
	@Enumerated(EnumType.STRING)
    private ServiceType serviceType;
	private Integer numberBedroom;
	private String description;
	
	@Autowired
	PropertyRepository propertyRepository;

	
	public String outcome(){
		return "/propertydetails.jsf?faces-redirect=true";
	}
	
	public String goToHouseDetails(String param)
	{
		System.out.println("test");
		Long id1=Long.parseLong(param);
		id=id1;
		return "/propertydetails.jsf?faces-redirect=true";
	}
	

	public Property getHouse() {
		return house;
	}

	public void setHouse(Property house) {
		this.house = house;
	}

	public String showProperty(Property p) {
		
		this.setIdHouse(p.getId());	
		
		return "/propertydetails.xhtml?faces-redirect=true";
	}
	
	
	public Property getPropertyid(){
		Property property5 =iHouseService.findByIdd(getIdHouse());
		return property5 ;
	}
	
	
	public String goBack()
	{
	return "/main.xhtml?faces-redirect=true";
	}
	
	public Property getProperty1() {
		return property1;
	}
	public void setProperty1(Property house) {
		property1 = house;
	}
	public Property getProperty2() {
		return property2;
	}
	public void setProperty2(Property house) {
		property2 = house;
	}

	

	public IPropertyzService getiHouseService() {
		return iHouseService;
	}

	public void setiHouseService(IPropertyzService iHouseService) {
		this.iHouseService = iHouseService;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getNumberBedroom() {
		return numberBedroom;
	}

	public void setNumberBedroom(Integer numberBedroom) {
		this.numberBedroom = numberBedroom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
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


	public List<Property> getProperties() {
		properties=iHouseService.getAllHouses();
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	public Property getHouseById(Long id) {
		house=iHouseService.findByIdd(id);
		return house;
	}

	public Long getIdHouse() {
		return id;
	}

	public void setIdHouse(Long id) {
		this.id = id;
	}

	


	

}

