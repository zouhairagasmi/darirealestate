package tn.esprit.spring.interfaces;

import java.util.List;


import tn.esprit.spring.entity.User;






public interface IUserService {
	public void addUserAndAssignToSubscription(User user,Long idS);
	//public void addProjectAndAssignToClient(Project project, Long clientId);
	public User getUserById(Long idU);
	public void updateUserById(User user, Long idU);
	//public Project getProjectById(Long projectId);
	public void deleteUser(User user);
	public Long countUsers();
	public void deleteAllUsers();
	public List<User> getAllUsers();
	//public void updateProject(Long projectId, Project project);
}
