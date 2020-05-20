package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Vues;

public interface VuesRepository extends CrudRepository< Vues, Long > {

	
	/*
	@Query("Select count(firstName) from User u "
			+ "join u.Vues v "
			+ "where v.idVues=:idVues and v.date=:date")
	public int getNbrVuesByDate(@Param("idVues")Long idVues,@Param("date")Date date) ;*/
	
}
