package tn.esprit.spring.controller;



import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



@Scope(value = "session")
@Controller(value = "subscriptionController")
@ELBeanName(value = "subscriptionController")
@Join(path = "/", to = "/loginn.jsf")
public class SubscriptionController {
	
	public String goToSubscriptions() {

		String navigateTo = "null";
		navigateTo = "/subscriptions.xhtml?faces-redirect=true";
		return navigateTo;
		}

}
