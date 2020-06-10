package tn.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IUserService;

@Scope(value = "session")
@Controller(value = "UserController")
@ELBeanName(value = "UserController")
@Join(path = "/", to = "/login.jsf")

public class UserController {

	@Autowired
	private IUserService userservice;

	private String login;
	private String password;
	public static User user;
	private Boolean loggedIn;
	private String email;
	private Role role;
	private Boolean isActif;
	private List<User> users;
	private Integer userIdToBeUpdated;

	public String dologin() {

		String navigateTo = "null";
		user = userservice.getEmployeByEmailAndPassword(login, password);
		if (user != null && user.getRole() == Role.USER) {
			navigateTo = "/welcome.xhtml?faces-redirect=true";
			loggedIn = true;
		} else {
			FacesMessage facesMessage = new FacesMessage(
					"Login Failed: please check your username/password and try again.");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}

	public IUserService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUserService userservice) {
		this.userservice = userservice;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getUserIdToBeUpdated() {
		return userIdToBeUpdated;
	}

	public void setUserIdToBeUpdated(Integer userIdToBeUpdated) {
		this.userIdToBeUpdated = userIdToBeUpdated;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

}
