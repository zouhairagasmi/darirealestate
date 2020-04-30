package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
	  @Transactional
	    @Modifying
	    @Query("update User u set u.username = ?1, u.password = ?2, u.firstname = ?3, u.lastname= ?4, u.gender= ?5 ,u.phone= ?6, u.adress= ?7, u.dateofbirth= ?8 ,u.rating= ?9, u.email= ?10 , u.role = ?11 where u.idU = ?12")
	    void updateUserById(String username, String password, String firstname, String lastname, String gender, Long phone, String adress,Date date,Integer rating,String email,Role role, Long idU);
	  
	  User findByIdU(Long idU);


}
