package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.House;

public interface HouseRepository extends CrudRepository<House, Long>{

}
