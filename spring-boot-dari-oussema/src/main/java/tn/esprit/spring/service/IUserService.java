package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.User;


public interface IUserService {
	public void addUser(User user);
	public User getUserById(Long idU);
	public void updateUserById(User user, Long idU);
	public List<User> getAllUsers();
	public void deleteUser(User user);
	public Long countUsers();
	public void deleteAllUsers();
	public User getUserByUsernameAndPassword(String username, String password);
}