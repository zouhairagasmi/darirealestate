package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.House;
import tn.esprit.spring.services.IHouseService;

@RestController
public class HouseController {
	@Autowired
	IHouseService houseService;
	
	@PostMapping("/add-house")
	@ResponseBody
	public Long addHouse(@RequestBody House u) {
		Long house  = houseService.addHouse (u);
		return house ;
	}
	
	
}
