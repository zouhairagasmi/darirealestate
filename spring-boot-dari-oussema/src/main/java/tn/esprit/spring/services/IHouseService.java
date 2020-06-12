package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.House;

public interface IHouseService {
	public Long addHouse(House house);

	public House findByIdd(Long id);

	public List<House> getAllHouses();
}
