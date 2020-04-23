package tn.esprit.spring.controller;






import java.util.List;



import javax.persistence.NoResultException;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Subscription;

import tn.esprit.spring.interfaces.ISubscriptionService;


@RestController
public class RestSubscriptionController {
	@Autowired
	private ISubscriptionService subscriptionService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	  /**
     * Ajouter un abonnement
     */
	@RequestMapping(value = "/addabo/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addSubscription(@RequestBody Subscription subscription){
    	logger.debug("Invocation de la resource : POST /addabo/");
    	subscriptionService.addSubscription(subscription);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	/**
	 * Mettre a jour les informations d'un abonnement
	 * @param projet
	 * @param clientId
	 */
	@RequestMapping(value = "/modifyabo/{idS}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateSubscription(@RequestBody Subscription subscription, 
    											@PathVariable("idS") Long idS){
    	logger.debug("Invocation de la resource : PUT /modifyabo/{idS}");
    	try{
    		subscriptionService.updateSubscription(idS, subscription);
    	}catch (NoResultException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	//afficher un abonnement 
    @GetMapping(value = "showabo/{idS}")
    @ResponseBody
	public Subscription getSubscriptionById(@PathVariable("idS") Long idS) {

		return subscriptionService.getSubscriptionById(idS);
	}
    
    // http://localhost:8081/SpringMVC/servlet/getAllDepartementsNamesByEntreprise/1
    @GetMapping(value = "getAllUsersNamesBySubscription/{idS}")
    @ResponseBody
	public List<String> getAllUsersNamesBySubscription(@PathVariable("idS") Long idS) {
		return subscriptionService.getAllUsersNamesBySubscription(idS);
	}

}
