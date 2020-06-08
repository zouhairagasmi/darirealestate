package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;

public interface IPropertyService {

	public List<Property> retrieveAll();
	
	public Property addProperty(Property P);
	
	public void deleteById(Long id);
	
	public Property updateById(Property P);
	
	//public void affecterLocationAProperty(Long idLocation, Long id);
	
	public void affecterPropertyAFile(String idFile,Long id);
	
	public List<Property> getAllPropertyByBuildingTypeEtServiceType( BuildingType buildingType,ServiceType serviceType);

	//public List<Property> getNearstLocation(Double latitude,Double longitude);

}
