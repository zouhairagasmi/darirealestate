package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.controller.IUserService;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;



@Component
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
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
	
	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}
	
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
	
	
}
