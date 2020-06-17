package tn.esprit.spring.controller;

import java.util.Date;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.ServiceType;
import tn.esprit.spring.service.IUserService;
import tn.esprit.spring.service.PropertyJSFService;




@Scope(value = "session")
@Controller(value = "propertyController")
@ELBeanName(value = "propertyController")
@Join(path = "/", to = "/manageproperties.jsf")
public class PropertyController {
	
	@Autowired
	PropertyJSFService propertyService;
	@Autowired
	IUserService iEmployeService;
	
	private String name;
	private Double price;
	private BuildingType buildingType;
	private ServiceType serviceType;
	private String description;
	private Integer numberBedroom;
    private Integer numberWc;
    private Boolean elevator;
    private Boolean furnished;
    private Boolean pool;
    private Boolean garage;
	public Date createdDate;
    private Boolean neartransport;
    private Boolean heating;
    private String photo;
    private String province;
    private String town;
    private Double latitude;
    private Double longitude;
	private String ref;
	private Boolean visible;
	private Boolean sold;
	private Boolean terrace;
	private Boolean ac;
	private Boolean office;
	private Boolean storage;
    private Long propertyIdToBeUpdated;
	private List<Property> properties;
	private List<Property> properties1;
	private List<Property> properties2;
	private Property property;
	//private Boolean loggedIn;
	
	private String login;
	private String password;
	private User employe;
	private Boolean loggedIn;
	private String email;
	private Boolean isActif;
	private Role role;
	private Integer employeIdToBeUpdated;
	private List<User> employes;
	
	
	public List<Property> getProperties() {
		properties = propertyService.getAllProperty();
		return properties;
	}
	
	 public String getProperties1(String name) {

			String navigateTo = "null";
			List<Property> properties1 = propertyService.findAllByName(name);
			if (properties1 != null ) {
				
				navigateTo = "/detailsProperty.xhtml?faces-redirect=true";
				loggedIn = true;
			} else {
				FacesMessage facesMessage = new FacesMessage(
						"Login Failed: please check your buildingType/serviceType and try again.");
				FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
			}
			
			return navigateTo;
			}

	 
	 public String dorecherche() {

			String navigateTo = "null";
			navigateTo = "/searchresult.xhtml?faces-redirect=true";
			return navigateTo;
			}
	 
	public List<Property> getProperties1() {
			properties1=propertyService.getAllPropertyByBuildingTypeEtServiceType(buildingType,serviceType,town);
			return properties1;
		}
		
	public List<Property> getProperties2() {
			properties2=propertyService.findAllByName(name);
				return properties2;
			}

	public String detail() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/detailsProperty.xhtml?faces-redirect=true";
	}

	public String rechercheProperty()
	{
		String navigateTo = "null";
		navigateTo = "/recherche.xhtml?faces-redirect=true";
		return navigateTo;
	}
	
	
	public String ajouter()
	{
			String navigateTo = "null";
			navigateTo = "/welcom.xhtml?faces-redirect=true";
			return navigateTo;
	}
	
	public String retour()
	{
			String navigateTo = "null";
			navigateTo = "/index.xhtml?faces-redirect=true";
			return navigateTo;
	}
	
	public String photo()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "/video.xhtml?faces-redirect=true";
	}

	

	
	public void deleteProperty(Long propertyid) {
		propertyService.deleteProperty(propertyid);
	}
	public String ajouterProperty() {
		String navigateTo="null";
		if(!loggedIn) return "/loginn.xhtml";
		propertyService.ajouterProperty(new Property(name, price, buildingType, serviceType,
				 description,numberBedroom, numberWc,furnished, garage, createdDate,
			 province, town, latitude, longitude));
		navigateTo = "/welcom.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public PropertyController() {
		super();
		property=new Property();
		loggedIn = false;
		}
	
	

	/*
	public void ajouterProperty() {
		propertyService.ajouterProperty(new PropertyJSF(name,price, buildingType, serviceType,description, province, town, latitude, longitude));
		
	}
		
	}
		public void mettreAjourProperty() {
		PropertyJSF e = new PropertyJSF(name,price, buildingType, serviceType,description,province, town, latitude, longitude);
		propertyService.updateProperty(e);
	}

	

	public void modifier(PropertyJSF property) {
		this.setName(property.getName());
		this.setPrice(property.getPrice());
		this.setBuildingType(property.getBuildingType());
		this.setServiceType(property.getServiceType());
		this.setDescription(property.getDescription());
		this.setProvince(property.getProvince());
		this.setTown(property.getTown());
		this.setLatitude(property.getLatitude());
		this.setLongitude(property.getLongitude());
		this.setPropertyIdToBeUpdated(property.getId());
	}
*/

	public void mettreAjourProperty() {
		Property e = new Property(propertyIdToBeUpdated,name, price,
				 description,numberBedroom, numberWc,furnished, garage,
			 province, town, pool, ac, heating, elevator, neartransport, storage, office, terrace);
		propertyService.updatePropertyById(e, propertyIdToBeUpdated  ); 
	}

	
	public void modifier(Property property) {
		this.setName(property.getName());
		this.setPrice(property.getPrice());
		this.setDescription(property.getDescription());
		this.setNumberBedroom(property.getNumberBedroom());
		this.setNumberWc(property.getNumberWc());
		this.setFurnished(property.getFurnished());
		this.setGarage(property.getGarage());
		this.setProvince(property.getProvince());
		this.setTown(property.getTown());
		this.setPool(property.getPool());
		this.setAc(property.getAc());
		this.setHeating(property.getHeating());
		this.setElevator(property.getElevator());
		this.setNeartransport(property.getNeartransport());
		this.setStorage(property.getStorage());
		this.setOffice(property.getOffice());
		this.setTerrace(property.getTerrace());
		
		

		this.setPropertyIdToBeUpdated(property.getId());
	}
	


	
	
	
	
	
	
//	public String dologin() {
//
//		String navigateTo = "null";
//		Employe employe = iEmployeService.getEmployeByEmailAndPassword(login, password);
//		if (employe != null && employe.getRole() == Role.ADMINISTRATEUR) {
//		navigateTo = "/index.xhtml?faces-redirect=true";
//		loggedIn = true;
//		} else {
//		FacesMessage facesMessage = new FacesMessage(
//		"Login Failed: please check your username/password and try again.");
//		FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
//		}
//		return navigateTo;
//		}
//
//		public String doLogout() {
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//		return "/login.xhtml?faces-redirect=true";
//		}

		
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	public Boolean getTerrace() {
		return terrace;
	}

	public void setTerrace(Boolean terrace) {
		this.terrace = terrace;
	}

	public Boolean getAc() {
		return ac;
	}

	public void setAc(Boolean ac) {
		this.ac = ac;
	}

	public Boolean getOffice() {
		return office;
	}

	public void setOffice(Boolean office) {
		this.office = office;
	}

	public Boolean getStorage() {
		return storage;
	}

	public void setStorage(Boolean storage) {
		this.storage = storage;
	}



	public IUserService getiEmployeService() {
		return iEmployeService;
	}

	public PropertyJSFService getPropertyService() {
		return propertyService;
	}


	public void setPropertyService(PropertyJSFService propertyService) {
		this.propertyService = propertyService;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getNumberBedroom() {
		return numberBedroom;
	}


	public void setNumberBedroom(Integer numberBedroom) {
		this.numberBedroom = numberBedroom;
	}


	public Integer getNumberWc() {
		return numberWc;
	}


	public void setNumberWc(Integer numberWc) {
		this.numberWc = numberWc;
	}

	public Boolean getElevator() {
		return elevator;
	}


	public void setElevator(Boolean elevator) {
		this.elevator = elevator;
	}


	public Boolean getFurnished() {
		return furnished;
	}


	public void setFurnished(Boolean furnished) {
		this.furnished = furnished;
	}


	public Boolean getPool() {
		return pool;
	}


	public void setPool(Boolean pool) {
		this.pool = pool;
	}


	public Boolean getGarage() {
		return garage;
	}


	public void setGarage(Boolean garage) {
		this.garage = garage;
	}



	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Boolean getNeartransport() {
		return neartransport;
	}


	public void setNeartransport(Boolean neartransport) {
		this.neartransport = neartransport;
	}


	public Boolean getHeating() {
		return heating;
	}

	public void setHeating(Boolean heating) {
		this.heating = heating;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getTown() {
		return town;
	}


	public void setTown(String town) {
		this.town = town;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Long getPropertyIdToBeUpdated() {
		return propertyIdToBeUpdated;
	}


	public void setPropertyIdToBeUpdated(Long propertyIdToBeUpdated) {
		this.propertyIdToBeUpdated = propertyIdToBeUpdated;
	}




	public List<User> getEmployes() {
		return employes;
	}



	public void setProperties1(List<Property> properties1) {
		this.properties1 = properties1;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	



	public void setProperties2(List<Property> properties2) {
		this.properties2 = properties2;
	}



public Property getProperty() {
		return property;
	}


	public void setProperty(Property property) {
		this.property = property;
	}


public IUserService getiUserService() {
return iEmployeService;
}

public void setiEmployeService(IUserService iEmployeService) {
this.iEmployeService = iEmployeService;
}

public String getLogin() {
return login;
}

public void setLogin(String login) {
this.login = login;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public User getEmploye() {
return employe;
}

public void setEmploye(User employe) {
this.employe = employe;
}


public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public Boolean getIsActif() {
return isActif;
}

public void setIsActif(Boolean isActif) {
this.isActif = isActif;
}

public Role getRole() {
return role;
}

public void setRole(Role role) {
this.role = role;
}

public void setEmployes(List<User> employes) {
this.employes = employes;
}

public Integer getEmployeIdToBeUpdated() {
return employeIdToBeUpdated;
}

public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
this.employeIdToBeUpdated = employeIdToBeUpdated;
}


}
