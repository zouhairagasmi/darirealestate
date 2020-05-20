package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Location;

public interface LocationRepository extends CrudRepository< Location, Long >{

}
