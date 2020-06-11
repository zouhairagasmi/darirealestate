package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IFavoritsService;
import tn.esprit.spring.repository.FavoritsRepository;
import tn.esprit.spring.repository.UserRepository;

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
	favorit.setTitle(title);
	favoritsRepository.save(favorit);
	
}

@Override
public Favorits updateFavorit(Favorits favorit) {
	Favorits favorit2 = favoritsRepository.findById(favorit.getId()).get();
	favorit2.setTitle(favorit.getTitle());
//	user1.setLastname(user.getLastname());
//	user1.setDate(user.getDate());
	favoritsRepository.save(favorit2);
	return favorit2;
}



@Override
public Favorits findByIdd(Long id) {
	Favorits favorit = favoritsRepository.findById(id).get();
	return favorit;
}


}


