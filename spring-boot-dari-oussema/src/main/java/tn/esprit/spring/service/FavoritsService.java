package tn.esprit.spring.service;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Visits;
import tn.esprit.spring.repository.FavoritsRepository;

@Service
public class FavoritsService implements IFavoritsService {


private static final String idd = null;
@Autowired
FavoritsRepository favoritsRepository;

@Override
public Favorits addFavorit(Favorits favorit) {
	Date now = new Date();  
	favorit.setDate(now);
	
	return favoritsRepository.save(favorit);
}

@Override
public List<Favorits> findByuserId(Long id) {
	//List<Visits> list = visitRepository.findVisitByIdVisitor(id);
	return favoritsRepository.findFavByIdUser(id);
}

@Override
public void deleteFavorit(Long id) {
	favoritsRepository.deleteById(id);
}

@Override
public List<Favorits> getAllFavorits() {
	return (List<Favorits>)favoritsRepository.findAll();
}

@Override
public void updateFavorits(Long id, String title) {
	Favorits favorit = favoritsRepository.findById(id).get();
	favoritsRepository.save(favorit);
	
}

@Override
public Favorits updateFavorit(Favorits favorit) {
	Favorits favorit2 = favoritsRepository.findById(favorit.getId()).get();
	favoritsRepository.save(favorit2);
	return favorit2;
}



@Override
public Favorits findByIdd(Long id) {
	Favorits favorit = favoritsRepository.findById(id).get();
	return favorit;
}

public List<Favorits> findByUserr (User user){
	return (List<Favorits>)favoritsRepository.findByUser(user);
}


}


