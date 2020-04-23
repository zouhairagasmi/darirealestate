package tn.esprit.spring.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IUserService;
import tn.esprit.spring.repository.UserRepository;



@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getEmployeByEmailAndPassword(String login, String password) {

		return userRepository.getEmployeByEmailAndPassword(login, password);
		}
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User getUserById(Long idU){
		return userRepository.findByIdU(idU);
	}
	@Override
	public void updateUserById(User user, Long idU) {
		userRepository.updateUserById(user.getUsername()
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
										, idU);
	}
	/*@Override
	public void banUserById(Long idU) {
		userRepository.banUserById(idU);
	}*/
	
	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
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
	
	
}
