package tn.esprit.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.ServiceType;
import tn.esprit.spring.interfaces.IPropertyService;
import tn.esprit.spring.service.EmailService;
@Controller
@RestController
public class PropertyRestControlImpl {

	@Autowired 
	IPropertyService ServiceProperty; 
	
	@Autowired 
	EmailService emailService; 
	
	// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-Property
		@GetMapping("/retrieve-all-Property")
		@ResponseBody
		public List<Property> getProperty() {
			List<Property> list = ServiceProperty.retrieveAll() ;
			return list;
		}
		
		// Ajouter Post: http://localhost:8081/SpringMVC/servlet/add-Property
			@PostMapping("/add-Property")
			@ResponseBody
			public Property addProperty(@RequestBody Property P) {
				LocalDate today = LocalDate.now();
				P.created=today;
				Property Property = ServiceProperty.addProperty(P); 
				return Property;
			}
			
			 // http://localhost:8081/SpringMVC/servlet/deleteById/1
		    @DeleteMapping("/deleteById/{id}") 
			@ResponseBody 
			public void deleteById(@PathVariable("id")Long id)
			{
		    	ServiceProperty.deleteById(id);
			}
			
		 // http://localhost:8081/SpringMVC/servlet/modify-Property
		    @PutMapping("/modify-Property")
		    @ResponseBody
		    public Property updateProperty(@RequestBody Property Property) {
		    return ServiceProperty.updateById(Property);
		    }
		   /* 
			
			// http://localhost:8081/SpringMVC/servlet/affecterLocationAProperty/1/1
		    @PutMapping(value = "/affecterLocationAProperty/{idLocation}/{id}") 
		    
			public void affecterLocationAProperty(@PathVariable("idLocation")Long idLocation, @PathVariable("id")Long Id) {
		    	ServiceProperty.affecterLocationAProperty(idLocation, Id);
			}
		    */
		    
		    // http://localhost:8081/SpringMVC/servlet/affecterDBFileAProperty/1/1
		    @PutMapping("/affecterDBFileAProperty/{idFile}/{id}") 
			public void affecterDBFileAProperty(@PathVariable("idFile")String idFile, @PathVariable("id")Long id) {
		    	ServiceProperty.affecterPropertyAFile(idFile, id);
			}
		    
		    // API MAIL
		    // http://localhost:8081/SpringMVC/servlet/Mail/{to}/{subject}/{body}
			@PostMapping("/Mail/{to}/{subject}/{body}")
			@ResponseBody
			@RequestMapping()
			public void sendMail(@RequestParam("to") String to,@RequestParam("subject") String subject,@RequestParam("body") String body) {
				
				emailService.sendMail( to, subject,  body);
			}
	
			// RECHERCHE BY BuildingType & ServiceType
			// URL : http://localhost:8081/SpringMVC/servlet/getAllPropertyByBuildingTypeEtServiceType/HOUSE/RENT
		    @GetMapping(value = "getAllPropertyByBuildingTypeEtServiceType/{buildingType}/{serviceType}")
		    @ResponseBody
			public List<Property> getAllPropertyByBuildingTypeEtServiceType(@PathVariable("buildingType") BuildingType buildingType,@PathVariable("serviceType") ServiceType serviceType) {

				return ServiceProperty.getAllPropertyByBuildingTypeEtServiceType(buildingType, serviceType);
			}

		    /*// find latitudes and longitudes in a distance less than 28 miles by kilometers
		    //URL : http://localhost:8081/SpringMVC/servlet/getNearstLocation/{lat}/{lng}
		    @GetMapping(value = "/getNearstLocation/{lat}/{lng}")
		    @ResponseBody
			public List<Property> getNearstLocation(@PathVariable("lat") Double latitude,@PathVariable("lng") Double longitude) {

				return ServiceProperty.getNearstLocation(latitude, longitude);
			}
		    */
} 
 