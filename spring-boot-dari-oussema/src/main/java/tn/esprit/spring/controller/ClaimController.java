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
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.Subscription;
//import tn.esprit.spring.interfaces.ISubscriptionService;
import tn.esprit.spring.interfaces.IClaimService;



@Scope(value = "session")
@Controller(value = "claimController")
@ELBeanName(value = "claimController")
//@Join(path = "/", to = "/login.jsf")

public class ClaimController {
	
public IClaimService getiClaimService() {
		return iClaimService;
	}


	public void setiClaimService(IClaimService iClaimService) {
		this.iClaimService = iClaimService;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


@Autowired
IClaimService iClaimService;
private String Status;
private String Type;
private String Description;
private List<Claim> claims;
private Long claimIdToBeUpdated;


public Long getClaimIdToBeUpdated() {
	return claimIdToBeUpdated;
}


public void setClaimIdToBeUpdated(Long claimIdToBeUpdated) {
	this.claimIdToBeUpdated = claimIdToBeUpdated;
}


public void ajouterClaim(){
	iClaimService.addClaim(new Claim(Description,Status,Type));
	}

	
	
	
	
	
	
public List<Claim> getClaims() {
	claims = iClaimService.getAllClaims();
	return claims;
}



public void setClaims(List<Claim> claims) {
	this.claims = claims;
}

public String goToClaims() {

String navigateTo = "null";
navigateTo = "/claims1.xhtml?faces-redirect=true";
return navigateTo;
}

public void modifierClaim(Claim claim)
{	
this.setDescription(claim.getDescription());
this.setStatus(claim.getStatus());
this.setType(claim.getType());

this.setClaimIdToBeUpdated(claim.getIdClaim());
}

public void removeClaim(Long idClaim)
{
iClaimService.deleteClaim1(idClaim);
}
public void mettreAjourClaim(){
	Claim u= new Claim(claimIdToBeUpdated, Description,Status,Type );
	iClaimService.updateClaimById(u, claimIdToBeUpdated);
	}
	
}
