package tn.esprit.spring.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import tn.esprit.spring.entity.Subscription;

import tn.esprit.spring.interfaces.ISubscriptionService;
import tn.esprit.spring.repository.SubscriptionRepository;


@Component
public class SubscriptionService  implements ISubscriptionService{
	@Autowired
	private SubscriptionRepository subscriptioRepository;
	
	
	
	/**
	ajouter un abonnement
	 */
	@Override
	public void addSubscription(Subscription subscription) {
		subscriptioRepository.save(subscription);
	}
	
	
	/**
	 * trouver un abonnement 
	 */
	@Override
	public Subscription getSubscriptionById(Long idS){
		return subscriptioRepository.findByIdS(idS);
	}
	
	
	/**
	 * Supprimer tous les abos
	 */
	@Override
	public void deleteAllSubscriptions() {
		subscriptioRepository.deleteAll();
	}
	
	
	/**
	 * Récupérer tous abos
	 */
	@Override
	public List<Subscription> getAllSubscriptions() {
		//https://jira.spring.io/browse/DATACMNS-21
		//Ce cast n'est pas une bonne pratique ?
		return (List<Subscription>) subscriptioRepository.findAll();
	}
	
	

	
	
	/**
	 * Mettre a jour les informations d'un abonnement
	 */
	@Override
	public void updateSubscription(Long idS, Subscription subscription) {
		subscriptioRepository.updateSubscriptionByIdS(subscription.getDescription()
										,subscription.getName()
										,subscription.getPrice()
										, idS);
	}

	

	
	

}
