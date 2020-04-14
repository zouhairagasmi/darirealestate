package tn.esprit.spring.controller;


import java.util.List;



import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IUserService;



@RestController
public class UserController {
	
	@Autowired
	private IUserService userinfoservice;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Afficher un user
	@RequestMapping(value = "/showuser/{idU}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("idU") Long idU) {
    	logger.debug("Invocation de la resource : GET /showuser/{idU}");
    	User user = userinfoservice.getUserById(idU);
        if (user == null) {
        	logger.info("Impossible de récupérer le client");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	//ajouter un user et l'affecter a un abonnement 
	@RequestMapping(value = "/adduser/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@org.springframework.web.bind.annotation.RequestBody User user, @RequestParam("idS") Long idS){
    	logger.debug("Invocation de la resource : POST /adduser/");
    	userinfoservice.addUserAndAssignToSubscription(user, idS);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	
	//modifier user
	@RequestMapping(value = "/modifyuser/{idU}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable("idU") Long idU, @org.springframework.web.bind.annotation.RequestBody User user){
    	logger.debug("Invocation de la resource : PUT /modifyuser/{idU}");
    	userinfoservice.updateUserById(user, idU);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	//supprimer user
	@RequestMapping(value = "/deleteuser/{idU}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("idU") Long idU){
    	logger.debug("Invocation de la resource : DELETE /deleteuser/{idU}");
    	userinfoservice.deleteUser(new User(idU));
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	/**
     * afficher tous les utilisateurs
     */
	@RequestMapping(value = "/showallusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
    	logger.debug("Invocation de la resource : GET /showallusers");
    	List<User> users = userinfoservice.getAllUsers();
    	if(users.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
