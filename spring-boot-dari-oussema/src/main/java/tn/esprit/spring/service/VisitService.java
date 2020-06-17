package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Property;
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
	@Transactional
	public void updateDateByVisitId(Visits visit) {
		visitRepository.save(visit);
	}
	
	
	@Override
	public List<Visits> findViByIdUser(Long id) {
		//List<Visits> list = visitRepository.findVisitByIdVisitor(id);
		return visitRepository.findViByIdUser(id);
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
	public void updateVisitById(Visits prop, Long id) {
		visitRepository.updateVisitById(prop.getDateVisit(), id);
		
	}
	
	@Override
	public List<Visits> findByuserId(Long id) {
		return visitRepository.findVisitByIdVisitor(id);
	}
	
	@Override
	public void deleteVisit(Long visitId) {
		visitRepository.deleteById(visitId);
	}

	
}