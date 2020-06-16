package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;
import tn.esprit.spring.repository.PropertyRepository;

@Service
public class PropertyzService implements IPropertyzService {
	
		@Autowired
		PropertyRepository propertyRepository;

		@Override
		public Long addHouse(Property house) {
			propertyRepository.save(house);
			return house.getId();
		}

		@Override
		public List<Property> getAllHouses() {
			return (List<Property>) propertyRepository.findAll();
		}

		@Override
		public Property findByIdd(Long id) {

			return propertyRepository.findHouseById(id);
		}

		@Override
		public void ajouterProperty(Property e) {
			propertyRepository.save(e);
		}

		@Override
		public List<Property> getAllProperty() {

			List<Property> properties = (List<Property>) propertyRepository.findAll();
			return properties;
		}

		@Override
		public void deleteProperty(Long propertyid) {

			propertyRepository.deleteById(propertyid);
		}

		@Override
		public void updateProperty(Property e) {
			propertyRepository.save(e);
		}

		@Override
		public List<Property> getPropertyWithLocation() {

			return null;
		}

		@Override
		public List<Property> getAllPropertyByBuildingTypeEtServiceType(BuildingType buildingType,
				ServiceType serviceType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Property> getPropertyName(String nom) {

			return propertyRepository.findByName(nom);

		}

}
