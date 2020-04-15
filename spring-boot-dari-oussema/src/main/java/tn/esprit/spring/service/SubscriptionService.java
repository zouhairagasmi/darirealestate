package tn.esprit.spring.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void updateSubscription(Long idS, Subscription subscription){
		Subscription subscriptionManagedEntity = subscriptioRepository.findByIdS(idS);
		if(subscriptionManagedEntity == null){
			throw new NoResultException();
		}
		subscriptionManagedEntity.setDescription(subscription.getDescription());
		subscriptionManagedEntity.setName(subscription.getName());
		subscriptionManagedEntity.setPrice(subscription.getPrice());
		
		// Il faut faire attention lorsqu'on utilise save pour mettre a jour un enregistrement dans
		// la base de données.
		// Dans ce cas si on utilise save, tout l'objet va etre sauvegardé dans la base,
		// y compris la valeur null de "client_id".
		//project.setId(projectId);
		//projectRepository.save(project);
	}

	
	

}
