package tn.esprit.spring.interfaces;

import java.util.List;


import tn.esprit.spring.entity.Subscription;

public interface ISubscriptionService {
	public void addSubscription(Subscription subscription);
	public Subscription getSubscriptionById(Long idS);
	public List<Subscription> getAllSubscriptions();
	public void deleteAllSubscriptions();
	public void updateSubscription(Long idS, Subscription subscription);
	List<String> getAllUsersNamesBySubscription(Long idS);
}
