package tn.esprit.spring.controller;

import java.util.List;

import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Visits;
import tn.esprit.spring.services.IVisitService;


@RestController
public class VisitController {
	@Autowired
	IVisitService visitService;
	//@Autowired
	//IUserService userService;

		// http://localhost:8081/SpringMVC/servlet/
		@RequestMapping("/")
		@ResponseWrapper
		public String welcome() { return "Hello, Welcome to MASMOUDI REAL ESTATE AGENCY."; }
		
		// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-visits
		@GetMapping("/retrieve-all-visits")
		@ResponseBody
		public List<Visits> getVisits() {
			List<Visits> list = visitService.getAllVisits();
			return list;
		}
		
		// Ajouter Visit : http://localhost:8081/SpringMVC/servlet/add-visit
		@PostMapping("/add-visit")
		@ResponseBody
		public Visits addVisit(@RequestBody Visits u) {
			//if(u.getDateVisit().after(u.getProperty().getDateVisitDebut()) && u.getDateVisit().before(u.getProperty().getDateVisitFin()) )
			Visits visit = visitService.addvisit(u);
			return visit;				
		}

		//http://localhost:8081/SpringMVC/servlet/retrieve-visit /{visit-id}
		@GetMapping("/retrieve-visit/{visit-id}")
		@ResponseBody
		public Visits getVisit(@PathVariable("visit-id") Long visitId) {
			return visitService.findByIdd(visitId);
		}
	
		//http://localhost:8081/SpringMVC/servlet/retrieve-visit /{visit-id}
		@GetMapping("/retrieve-visit-user/{user-id}")
		@ResponseBody
		public List<Visits> getVisitById(@PathVariable("user-id") Long userId) {
			//User visitor =userService.getUserById(userId);
			List<Visits> list = visitService.findByuserId(userId);
			return list;
		}
		
		//http://localhost:8081/SpringMVC/servlet/modify-visit /{visit-id}
		@PutMapping("/modify-visit/")
		@ResponseBody
		public void updateVisit(@RequestBody Visits visit) {
			visitService.updateDateByVisitId(visit);
		}
		
		//http://localhost:8081/SpringMVC/servlet/delete-visit/{visit-id}
		@DeleteMapping("/delete-visit/{visit-id}")
		@ResponseBody
		public void deleteVisit(@PathVariable("visit-id") Long visitId) {
			visitService.deleteVisit(visitId);
		}
}