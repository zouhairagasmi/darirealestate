package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "insuranceController")
@ELBeanName(value = "insuranceController")
@Join(path = "/", to = "/loginn.jsf")

public class InsuranceController {
	
	public String goToInsruances() {

		String navigateTo = "null";
		navigateTo = "/insurances.xhtml?faces-redirect=true";
		return navigateTo;
		}

}
