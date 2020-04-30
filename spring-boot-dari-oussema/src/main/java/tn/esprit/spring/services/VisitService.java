package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Visits;
import tn.esprit.spring.repository.VisitRepository;

@Service
public class VisitService implements IVisitService{
	@Autowired
	VisitRepository visitRepository;
	
	@Override
	public Visits addvisit(Visits visit){
		visitRepository.save(visit);
		return visit;
	}
	
	@Override
	public Visits updateDateByVisitId(Date date, Long visitId) {
		Visits visit = visitRepository.findById(visitId).get();
		visit.setDateVisit(date);
		visitRepository.save(visit);
		return visit;
	}
	
	@Override
	public List<Visits> getAllVisits() {
		return (List<Visits>)visitRepository.findAll();
	}
	
	@Override
	public Visits findByIdd(Long id) {
		Visits visit = visitRepository.findById(id).get();
		return visit;
	}
	
	@Override
	public void deleteVisit(Long visitId) {
		visitRepository.deleteById(visitId);
	}

	
}