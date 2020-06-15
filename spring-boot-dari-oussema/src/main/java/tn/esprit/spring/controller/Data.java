package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Role;

@Scope(value = "session")
@Controller(value = "data")
@ELBeanName(value = "data")
public class Data {
	
	public Role[] getRoles()
	{
	return Role.values();
	}

}