package tn.esprit.spring.interfaces;

import java.util.List;


import tn.esprit.spring.entity.User;






public interface IUserService {
	public void addUser(User user);
	public User getUserById(Long idU);
	public void updateUserById(User user, Long idU);
	public void deleteUser(User user);
	public Long countUsers();
	public void deleteAllUsers();
	public List<User> getAllUsers();
	void assignUserToSubscription(Long idU, Long idS);
}
