package tn.esprit.spring.controller;


import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IUserService;



@RestController
public class UserController {
	
	@Autowired
	private IUserService userinfoservice;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Afficher un user
	@RequestMapping(value = "/show/{idU}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("idU") Long idU) {
    	logger.debug("Invocation de la resource : GET /show/{idU}");
    	User user = userinfoservice.getUserById(idU);
        if (user == null) {
        	logger.info("Impossible de récupérer le client");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	//ajouter un user
	@RequestMapping(value = "/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@org.springframework.web.bind.annotation.RequestBody User user){
    	logger.debug("Invocation de la resource : POST /add/");
    	userinfoservice.addUser(user);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	//modifier user
	@RequestMapping(value = "/modify/{idU}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable("idU") Long idU, @org.springframework.web.bind.annotation.RequestBody User user){
    	logger.debug("Invocation de la resource : PUT /modify/");
    	userinfoservice.updateUserById(user, idU);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	//supprimer user
	@RequestMapping(value = "/delete/{idU}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("idU") Long idU){
    	logger.debug("Invocation de la resource : DELETE /delete/");
    	userinfoservice.deleteUser(new User(idU));
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
