package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Favorits;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritsRepository extends CrudRepository<Favorits, Long> {

}
