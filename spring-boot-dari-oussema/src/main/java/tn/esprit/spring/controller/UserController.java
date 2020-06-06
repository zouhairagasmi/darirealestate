package tn.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;



import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.interfaces.IUserService;



@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/login.jsf")

public class UserController {
    
@Autowired
IUserService iUserService;

private String email;
public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



private String username; 
private String password; 
private User user;
private String firstname;
private String lastname;
private Boolean isActif;
private Role role;
private Boolean loggedIn;
private List<User> users;
private Long userIdToBeUpdated;

public String dologin() {

String navigateTo = "null";
User user=iUserService.getUserByUsernameAndPassword(username, password);
if (user != null && user.getRole() == Role.ADMIN) {
navigateTo = "/welcome.xhtml?faces-redirect=true";
loggedIn = true;
}
else
{
FacesMessage facesMessage =
                new FacesMessage("Login Failed: please check your username/password and try again.");
            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
}
return navigateTo;
}



public String doLogout()
{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/login.xhtml?faces-redirect=true";
}


public String goToUsers() {

String navigateTo = "null";
navigateTo = "/users.xhtml?faces-redirect=true";
return navigateTo;
}

public void ajouterUser(){
	iUserService.addUser(new User(username,password, email, role, isActif));
	}






public void modifierUser(User user)
{this.setEmail(user.getEmail());
this.setIsActif(user.getIsActif());
this.setUsername(user.getUsername());
this.setPassword(user.getPassword());
this.setRole(user.getRole());
this.setUserIdToBeUpdated(user.getIdU());
}

public void removeUser(Long idU)
{
iUserService.deleteUser1(idU);
}

public void mettreAjourUser(){
	User u= new User(userIdToBeUpdated, username,password, email, role ,isActif );
	iUserService.updateUserById(u, userIdToBeUpdated);
	}


//Générer les Getters & les Setters



public IUserService getiUserService() {
	return iUserService;
}



public List<User> getUsers() {
	users = iUserService.getAllUsers();
	return users;
}



public void setUsers(List<User> users) {
	this.users = users;
}







public Long getUserIdToBeUpdated() {
	return userIdToBeUpdated;
}



public void setUserIdToBeUpdated(Long userIdToBeUpdated) {
	this.userIdToBeUpdated = userIdToBeUpdated;
}



public Boolean getIsActif() {
	return isActif;
}



public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}



public Role getRole() {
	return role;
}



public void setRole(Role role) {
	this.role = role;
}



public String getFirstname() {
	return firstname;
}



public void setFirstname(String firstname) {
	this.firstname = firstname;
}



public String getLastname() {
	return lastname;
}



public void setLastname(String lastname) {
	this.lastname = lastname;
}




public void setiUserService(IUserService iUserService) {
	this.iUserService = iUserService;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public User getUser() {
	return user;
}



public void setUser(User user) {
	this.user = user;
}



public Boolean getLoggedIn() {
	return loggedIn;
}



public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
}
    
}

