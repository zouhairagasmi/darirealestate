package tn.esprit.spring.interfaces;

import java.util.List;


import tn.esprit.spring.entity.Favorits;

public interface IFavoritsService {
	
	Favorits addFavorit(Favorits favorit);
	List<Favorits> getAllFavorits();
	void deleteFavorit(Long id);
	public void updateFavorits(Long id, String title);
	public Favorits findByIdd(Long id);
	
}
