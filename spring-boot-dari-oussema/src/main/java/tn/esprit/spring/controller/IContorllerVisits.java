package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Visits;
import tn.esprit.spring.services.IVisitService;

@Controller
public class IContorllerVisits {
	@Autowired
	IVisitService ivisitservice;
	
	public Visits addVisit(Visits visit)
	{
	ivisitservice.addvisit(visit);
	return visit;
	}
	
	public void updateDateByVisitId(Visits visit) {
		ivisitservice.updateDateByVisitId(visit);
	}
	
	
	
}
