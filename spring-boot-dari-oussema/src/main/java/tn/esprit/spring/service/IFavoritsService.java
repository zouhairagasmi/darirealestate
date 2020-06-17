package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.User;

public interface IFavoritsService {
	
	Favorits addFavorit(Favorits favorit);
	List<Favorits> getAllFavorits();
	void deleteFavorit(Long id);
	public void updateFavorits(Long id, String title);
	public Favorits findByIdd(Long id);
	public Favorits updateFavorit(Favorits favorit); 
	public List<Favorits> findByUserr (User user);
	
}
