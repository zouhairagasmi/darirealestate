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
	public Integer assignUserToSubscription(Long idU, Long idS);
	public void unassignUserToSubscription(Long idU);
	public void banUser(Long idU);
	public void unbanUser(Long idU);
	public User getUserByUsernameAndPassword(String username, String password) ;
}
