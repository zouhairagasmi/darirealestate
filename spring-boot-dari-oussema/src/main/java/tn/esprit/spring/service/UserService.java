package tn.esprit.spring.service;

import java.util.List;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IUserService;
import tn.esprit.spring.repository.SubscriptionRepository;
import tn.esprit.spring.repository.UserRepository;



@Component
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public User getUserById(Long idU){
		return userRepository.findById(idU).get();
	}
	@Override
	public void updateUserById(User user, Long idU) {
		userRepository.updateUserById(   user.getUsername()
										,user.getPassword()
										,user.getFirstname()
										,user.getLastname()
										,user.getGender()
										,user.getPhone()
										,user.getAdress()
										,user.getDateofbirth()
										,user.getRating()
										,user.getEmail()
										,user.getRole()
										,user.getStatus()
										,user.getBalance()
										,user.getIsActif()
										, idU);
	}
	
	
	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	@Override
	public void deleteUser1(Long idU) {
		userRepository.deleteById(idU);
	}
	
	@Override
	public Long countUsers() {
		return userRepository.count();
	}
	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
	@Override
	public List<User> getAllUsers() {
		//https://jira.spring.io/browse/DATACMNS-21
		//Ce cast n'est pas une bonne pratique ?
		return (List<User>) userRepository.findAll();
	}
	
	public Integer assignUserToSubscription(Long idU, Long idS) {
		//Le bout Master de cette relation N:1 est User  
				//donc il faut rajouter l'abonnement a User 
				// ==> c'est l'objet User(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Subscription subscriptionManagedEntity = subscriptionRepository.findById(idS).get();
				User userManagedEntity = userRepository.findById(idU).get();
				if(userManagedEntity.getSubscription()!=null)
				return 2;
				else if(userManagedEntity.getBalance()>=subscriptionManagedEntity.getPrice())
				{
				userManagedEntity.setSubscription(subscriptionManagedEntity);
				userManagedEntity.setBalance(userManagedEntity.getBalance()-subscriptionManagedEntity.getPrice());
				userRepository.save(userManagedEntity);
				return 1;
				}
				else 
				return 0;
		
	}
	@Transactional
	public void unassignUserToSubscription(Long idU)
	{
		User user = userRepository.findById(idU).get();
		user.setSubscription(null);
		userRepository.save(user);
			}
	@Override
	public void banUser(Long idU) {
		User userManagedEntity = userRepository.findById(idU).get();
		userManagedEntity.setStatus(0);
		userRepository.save(userManagedEntity);
	}
	
	@Override
	public void unbanUser(Long idU) {
		User userManagedEntity = userRepository.findById(idU).get();
		userManagedEntity.setStatus(1);
		userRepository.save(userManagedEntity);
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {

		return userRepository.getUserByUsernameAndPassword(username, password);
		}

}
