package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Visits;

public interface IVisitService {
	
	public Visits addvisit(Visits visit);
	public Visits updateDateByVisitId(Date date, Long visitId);
	public List<Visits> getAllVisits();
	public Visits findByIdd(Long id);
	public void deleteVisit(Long visitId);
	
	
}
