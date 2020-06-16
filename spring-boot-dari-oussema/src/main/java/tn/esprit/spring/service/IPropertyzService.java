package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;

public interface IPropertyzService {
	public Long addHouse(Property house);

	public List<Property> getAllHouses();

	public Property findByIdd(Long id);

	void ajouterProperty(Property e);

	public List<Property> getAllProperty();

	void deleteProperty(Long propertyid);

	void updateProperty(Property e);

	public List<Property> getAllPropertyByBuildingTypeEtServiceType(BuildingType buildingType, ServiceType serviceType);

	public List<Property> getPropertyWithLocation();
	public List<Property> getPropertyName(String nom);
}
