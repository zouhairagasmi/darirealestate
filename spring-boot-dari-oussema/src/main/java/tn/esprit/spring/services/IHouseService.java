package tn.esprit.spring.services;

import java.util.Optional;

import tn.esprit.spring.entity.House;

public interface IHouseService {
	public Long addHouse(House house);

	Optional<House> findByIdd(Long id);
}
