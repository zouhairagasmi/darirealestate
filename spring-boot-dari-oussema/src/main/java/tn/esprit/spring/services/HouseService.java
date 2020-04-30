package tn.esprit.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.House;
import tn.esprit.spring.repository.HouseRepository;

@Service
public class HouseService implements IHouseService{
	@Autowired
	HouseRepository houseRepository;
	
	@Override
	public Long addHouse(House house){
		houseRepository.save(house);
		return house.getIdHouse();
	}
	
	@Override
    public Optional<House> findByIdd(Long id) {

        return houseRepository.findById(id);
    }
	
}
