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
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.interfaces.ISubscriptionService;
import tn.esprit.spring.interfaces.IUserService;

@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/loginn.jsf")

public class UserController {

	@Autowired
	IUserService iUserService;

	@Autowired
	ISubscriptionService iSubscriptionService;

	private Long idCnx;
	public static User user;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String gender;
	private Long phone;
	private String adress;
	private int rating;
	private float balance;
	private Boolean isActif;
	private Role role;
	private Boolean loggedIn;
	private List<User> users;
	private Long userIdToBeUpdated;
	private Long idS;

	public ISubscriptionService getiSubscriptionService() {
		return iSubscriptionService;
	}

	public void setiSubscriptionService(ISubscriptionService iSubscriptionService) {
		this.iSubscriptionService = iSubscriptionService;
	}

	public Long getIdS() {
		return idS;
	}

	public void setIdS(Long idS) {
		this.idS = idS;
	}

	public UserController() {
		super();

	}

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRoleById() {
		return iUserService.getUserById(idCnx).getRole();
	}

	public String getFirstnameById() {
		return iUserService.getUserById(idCnx).getFirstname();
	}

	public String dologin() {

		String navigateTo = "null";
		user = iUserService.getUserByUsernameAndPassword(username, password);
		if (user == null) {
			FacesMessage facesMessage = new FacesMessage(
					"Login Failed: please check your username/password and try again.");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		} else if (user.getIsActif() == false) {
			FacesMessage facesMessage = new FacesMessage("Login Failed: Your account is banned ");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		} else if (user != null && user.getRole() == Role.ADMIN) {
			navigateTo = "/welcome1.xhtml?faces-redirect=true";
			this.setIdCnx(user.getIdU());
			loggedIn = true;
		} 

		else if (user != null && user.getRole() == Role.USER) {
			navigateTo = "/indexuser.xhtml?faces-redirect=true";
			this.setIdCnx(user.getIdU());
			loggedIn = true;
		}

		return navigateTo;
	}

	public void createAccount() {
		if (email == null) {

		} else {
			iUserService.addUser(new User(username, password, firstname, lastname, email, isActif = false));

			FacesMessage facesMessage = new FacesMessage("Account created wait for Administrator to give you access");
			FacesContext.getCurrentInstance().addMessage("form1:btn1", facesMessage);
		}
	}

	public String subscribe(Long idCnx, Long idS) {

		iUserService.assignUserToSubscription(idCnx, idS);
		return "/oursubscriptions.xhtml?faces-redirect=true";
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/loginn.xhtml?faces-redirect=true";
	}

	public String goToUsers() {

		String navigateTo = "null";
		navigateTo = "/users1.xhtml?faces-redirect=true";
		return navigateTo;
	}

	public String goToSubscriptionsUser() {

		String navigateTo = "null";
		navigateTo = "/subscriptionuser.xhtml?faces-redirect=true";
		return navigateTo;
	}

	public void ajouterUser() {
		iUserService.addUser(new User(username, password, firstname, lastname, phone, email, role, balance, isActif));
	}

	public void modifierUser(User user) {
		this.setEmail(user.getEmail());
		this.setBalance(user.getBalance());
		this.setIsActif(user.getIsActif());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setFirstname(user.getFirstname());
		this.setLastname(user.getLastname());
		this.setPhone(user.getPhone());
		this.setRole(user.getRole());
		this.setUserIdToBeUpdated(user.getIdU());
	}

	public void removeUser(Long idU) {
		iUserService.deleteUser1(idU);
	}

	public void mettreAjourUser() {
		User u = new User(userIdToBeUpdated, username, password, firstname, lastname, email, role, balance, isActif);
		iUserService.updateUserById(u, userIdToBeUpdated);
	}

	// Générer les Getters & les Setters

	public IUserService getiUserService() {
		return iUserService;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Long getIdCnx() {
		return idCnx;
	}

	public void setIdCnx(Long idCnx) {
		this.idCnx = idCnx;
	}

}
