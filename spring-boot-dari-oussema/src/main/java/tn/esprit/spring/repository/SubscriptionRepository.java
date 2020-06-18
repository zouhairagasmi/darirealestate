package tn.esprit.spring.repository;





import org.springframework.data.repository.CrudRepository;



import tn.esprit.spring.entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
	
}
