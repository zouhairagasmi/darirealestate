package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Scope(value = "session")
@Controller(value = "loanyears")
@ELBeanName(value = "loanyears")
public class Data1 {
	
	public int[] getLoanYears()
	{
		int[] intArray = new int[]{ 3,5,10,15,30 };
	return intArray;
	}
}
