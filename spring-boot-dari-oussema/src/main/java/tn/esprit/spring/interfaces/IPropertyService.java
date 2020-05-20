package tn.esprit.spring.interfaces;

import java.util.List;
import tn.esprit.spring.entity.Property;

public interface IPropertyService {

	public List<Property> retrieveAll();
	
	public Property addProperty(Property P);
	
	public void deleteById(Long id);
	
	public Property updateById(Property P);
	
	public void affecterLocationAProperty(Long idLocation, Long id);
	
	public void affecterPropertyAFile(String idFile,Long id);

}
