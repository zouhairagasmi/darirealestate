package tn.esprit.spring.repository;





import org.springframework.data.repository.CrudRepository;



import tn.esprit.spring.entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
	/*@Transactional
	@Modifying
    @Query("update Subscription u set u.description = ?1, u.name = ?2, u.price = ?3 where u.idU = ?4")
    void updateSubscriptionByIdS(String description, String name, Float price, Long idU);*/
	
	
	Subscription findByIdS(Long idS);
}
