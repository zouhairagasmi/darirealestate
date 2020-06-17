package tn.esprit.spring.service;


import java.util.List;


import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;


public interface IPropertyJSFService {
	
	//public Property getPropertyByDescriptionAndRef(String description, String ref) ;

	void ajouterProperty(Property e);

	//public PropertyJSF findAllById(Long id);
			
	public List<Property> getAllProperty();

	void deleteProperty(Long propertyid);

	//void modifier(Property property);

	void updateProperty(Property e);
	
	public List<Property> getAllPropertyByBuildingTypeEtServiceType(BuildingType buildingType,ServiceType serviceType,String town);

	//public void affecterPropertyAFile(String idFile, Long id);
	
	public List<Property> getPropertyWithLocation();
	
	public void updatePropertyById(Property prop, Long id);
	
	public List<Property> findPropByIdUser(Long id);
}
