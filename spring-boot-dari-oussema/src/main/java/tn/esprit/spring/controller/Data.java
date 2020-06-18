package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.BuildingType;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.ServiceType;
import tn.esprit.spring.entity.VisitType;

@Scope(value = "session")
@Controller(value = "data")
@ELBeanName(value = "data")
public class Data {
	
	public ServiceType[] getServiceTypes()
	{
		return ServiceType.values();
	}
	
	public BuildingType[] getBuildingTypes()
	{
		return BuildingType.values();
	}
	
	public VisitType[] getVisitTypes()
	{
	return VisitType.values();
	}
	public Role[] getRoles()
	{
	return Role.values();
	}
}
