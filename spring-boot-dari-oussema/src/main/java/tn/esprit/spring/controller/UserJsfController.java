package tn.esprit.spring.controller;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;


@Scope(value = "session")
@Controller(value = "userjsfController")
@ELBeanName(value = "userjsfController")
@Join(path = "/", to = "/loginn.jsf")


public class UserJsfController {
	
	@Autowired
	IUserService iUserService;

	private String username; 
	private String password; 
	private User user;
	private Boolean loggedIn;
	private Long Iduser;
	
	

	public UserJsfController() {
		super();
		user=new User();
		loggedIn=false;
	}

	public String dologin() {

	String navigateTo = "null";
	User user=iUserService.getUserByUsernameAndPassword(username, password);
	if (user != null && user.getRole() == Role.Client) {
	navigateTo = "/Client.xhtml?faces-redirect=true";
	loggedIn = true;
	Iduser=user.getIdU();
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
	return "/loginn.xhtml?faces-redirect=true";
	}

	//Générer les Getters & les Setters



	public IUserService getiUserService() {
		return iUserService;
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

	public Long getIduser() {
		return Iduser;
	}

	public void setIduser(Long iduser) {
		Iduser = iduser;
	}
	
}
