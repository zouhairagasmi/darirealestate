package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Favorits;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.User;
import java.util.List;

@Repository
public interface FavoritsRepository extends CrudRepository<Favorits, Long> {
	
	List<Favorits> findByUser(User user);

}
