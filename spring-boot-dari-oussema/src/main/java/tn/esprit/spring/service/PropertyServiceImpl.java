package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DBFile;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.interfaces.IPropertyService;
import tn.esprit.spring.repository.DBFileRepository;
import tn.esprit.spring.repository.LocationRepository;
import tn.esprit.spring.repository.PropertyRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VuesRepository;
@Service
public class PropertyServiceImpl implements IPropertyService{

	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VuesRepository vuesRepository;
	
	@Autowired
	DBFileRepository dbFileRepository;
	
	@Override
	public List<Property> retrieveAll() {
		// TODO Auto-generated method stub
		return (List<Property>) propertyRepository.findAll();
		
	}

	@Override
	public Property addProperty(Property P) {
		// TODO Auto-generated method stub
		return propertyRepository.save(P);
	
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		propertyRepository.deleteById(id);
		
	}

	@Override
	public Property updateById(Property P) {
		// TODO Auto-generated method stub
		return propertyRepository.save(P);
	}
	
	@Override
	public void affecterLocationAProperty(Long idLocation, Long Id) {
		Location locationManagedEntity = locationRepository.findById(idLocation).get();
		Property propertyManagedEntity = propertyRepository.findById( Id).get();
		
		locationManagedEntity.setProperty(propertyManagedEntity);
		locationRepository.save(locationManagedEntity);
	}

	
	@Override
	public void affecterPropertyAFile(String idFile, Long id) {
		//Long i= Long.valueOf(idFile);
    	DBFile dbFileManagedEntity = dbFileRepository.findById(idFile).get();
		Property propertyManagedEntity = propertyRepository.findById(id).get();
		
		dbFileManagedEntity.setProperty(propertyManagedEntity);
		dbFileRepository.save(dbFileManagedEntity);
	}
    

	
}
