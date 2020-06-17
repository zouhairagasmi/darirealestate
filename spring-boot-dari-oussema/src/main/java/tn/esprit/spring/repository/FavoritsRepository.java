package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FavoritsRepository extends CrudRepository<Favorits, Long> {
	//
	List<Favorits> findByUser(User user);
	
	@Query(
			  value = "SELECT * FROM Favorits v WHERE v.idu= ?1", 
			  nativeQuery = true)
			List<Favorits> findFavByIdUser(Long userId);

}
