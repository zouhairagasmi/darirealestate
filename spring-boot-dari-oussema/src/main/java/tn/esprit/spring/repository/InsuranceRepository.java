package tn.esprit.spring.repository;



import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance,Long> {

}
