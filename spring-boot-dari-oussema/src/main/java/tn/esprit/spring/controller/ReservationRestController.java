package tn.esprit.spring.controller;

import javax.xml.ws.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.interfaces.IReservationService;



@RestController
public class ReservationRestController {
	
	@Autowired
	IReservationService ReservationService;

	// http://localhost:8088/SpringRegister/servlet/
	@RequestMapping("/")
	@ResponseWrapper
	public String welcome() { return "welcome"; }
	
	
	@PostMapping("/addReservation")
	@ResponseBody
	public Reservation addUser(@RequestBody Reservation res) {
		Reservation reservation = ReservationService.save(res);
		return reservation;
	}
	
	
	
	
	
}
