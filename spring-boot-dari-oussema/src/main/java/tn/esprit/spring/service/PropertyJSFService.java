package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PropertyJSFRepository;

@Service
public class PropertyJSFService implements IPropertyJSFService{


	@Autowired
	PropertyJSFRepository propertyRepository;
	/*
	@Override
	public Property getPropertyByDescriptionAndRef(String description, String ref) {
		// TODO Auto-generated method stub
		return propertyRepository.getPropertyByDescriptionAndRef(description, ref); 
	}*/

	
	
	@Override
	public List<Property> findPropByIdUser(Long id) {
		return propertyRepository.findPropByIdUser(id);
	}
	
	@Override
	public void ajouterProperty(Property e) {
		// TODO Auto-generated method stub
		propertyRepository.save(e);
	}

	public List<Property> findAllById(Long id) {
		// TODO Auto-generated method stub
		List<Property> properties =  propertyRepository.findAllById(id);
		return properties;
	}
	public List<Property> findAllByName(String name) {
		// TODO Auto-generated method stub
		List<Property> properties =  propertyRepository.findAllByName(name);
		return properties;
	}
	
	@Override
	public List<Property> getAllProperty() {
		// TODO Auto-generated method stub
		List<Property> properties = (List<Property>) propertyRepository.findAll();
		return properties;
	}
	
	@Override
	public void updatePropertyById(Property prop, Long id) {
		propertyRepository.updatePropertyById(prop.getName()
										,prop.getPrice()
										,prop.getDescription()
										,prop.getProvince()
										,prop.getTown()
										,prop.getNumberBedroom()
										,prop.getNumberWc()
										,prop.getFurnished()
										,prop.getGarage()
										,prop.getPool()
										,prop.getAc()
										,prop.getHeating()
										,prop.getElevator()
										,prop.getNeartransport()
										,prop.getStorage()
										,prop.getOffice()
										,prop.getTerrace()
										, id);
		
	}
	

	@Override
	public void deleteProperty(Long propertyid) {
		// TODO Auto-generated method stub
		propertyRepository.deleteById(propertyid);
	}

	@Override
	public void updateProperty(Property e) {
		// TODO Auto-generated method stub
		propertyRepository.save(e);
	}
	

	@Override
	public List<Property> getPropertyWithLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> getAllPropertyByBuildingTypeEtServiceType(BuildingType buildingType,ServiceType serviceType,String town ) {
		// TODO Auto-generated method stub
		return propertyRepository.getAllPropertyByBuildingTypeEtServiceType(buildingType, serviceType,town );
		
	}
	
/*	@Override
	public void affecterPropertyAFile(String idFile, Long id) {
		//Long i= Long.valueOf(idFile);
    	DBFile dbFileManagedEntity = dbFileRepository.findById(idFile).get();
		PropertyJSF propertyManagedEntity = propertyRepository.findById(id).get();
		
		dbFileManagedEntity.setProperty(propertyManagedEntity);
		dbFileRepository.save(dbFileManagedEntity);
	}
*/

}
