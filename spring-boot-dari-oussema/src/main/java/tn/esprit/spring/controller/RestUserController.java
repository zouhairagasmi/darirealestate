package tn.esprit.spring.controller;


import java.util.List;






import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IUserService;



@RestController
public class RestUserController {
	
	@Autowired
	private IUserService userinfoservice;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*//Afficher un user
	@RequestMapping(value = "/showuser/{idU}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("idU") Long idU) {
    	logger.debug("Invocation de la resource : GET /showuser/{idU}");
    	User user = userinfoservice.getUserById(idU);
        if (user == null) {
        	logger.info("Impossible de récupérer le client");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/
	//afficher un utilisateur a travers son id
	@GetMapping(value = "/showuser/{idU}")
	   @ResponseBody
	   public User getUsergetUserById(@PathVariable("idU")Long idU) {
			return userinfoservice.getUserById(idU);
		}
	
	//ajouter un user 
	@RequestMapping(value = "/adduser/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@org.springframework.web.bind.annotation.RequestBody User user){
    	logger.debug("Invocation de la resource : POST /adduser/");
    	userinfoservice.addUser(user);
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
	//affecter un utilisateur a un abonnement 
	 @PutMapping(value = "/assignuser/{idU}/{idS}") 
		public ResponseEntity<String> assignUserToSubscription(@PathVariable("idU")Long idU, @PathVariable("idS")Long idS) {
		 if(userinfoservice.assignUserToSubscription(idU, idS)==1)
			 return new ResponseEntity<>("Assigned successfully", HttpStatus.OK); 
		 else if(userinfoservice.assignUserToSubscription(idU, idS)==0)
			 return new ResponseEntity<>("Not enough balance", HttpStatus.OK);
		 else
			 return new ResponseEntity<>("Already assigned", HttpStatus.OK);
		}
	//annuler l'abonnement a un abonnement
		 @PutMapping(value = "/unassignuser/{idU}") 
			public ResponseEntity<String> unassignUserToSubscription(@PathVariable("idU")Long idU) {
			 userinfoservice.unassignUserToSubscription(idU);
				 return new ResponseEntity<>("unassigned successfully", HttpStatus.OK); 
			}
	 //ban user
	 @PutMapping(value = "/banuser/{idU}") 
		public ResponseEntity<String> banUser(@PathVariable("idU")Long idU) {
		 userinfoservice.banUser(idU);
			 return new ResponseEntity<>("User Banned successfully", HttpStatus.OK); 
	
		}
	 
	//unban user
		 @PutMapping(value = "/unbanuser/{idU}") 
			public ResponseEntity<String> unbanUser(@PathVariable("idU")Long idU) {
			 userinfoservice.unbanUser(idU);
				 return new ResponseEntity<>("User Unbanned successfully", HttpStatus.OK); 
		
			}

}
