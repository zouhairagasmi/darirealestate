package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Visits;

public interface VisitRepository extends CrudRepository<Visits, Long>{

	//@Query("select u from house u where u.id=:id")
	//House getHouseByiddd(@Param("id")Long id);

}
