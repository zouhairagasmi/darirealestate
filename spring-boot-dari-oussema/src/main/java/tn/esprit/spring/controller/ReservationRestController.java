package tn.esprit.spring.controller;

import java.util.List;
import javax.xml.ws.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Property;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.interfaces.IReservationService;



@RestController
public class ReservationRestController {
	
	@Autowired
	IReservationService ReservationService;
	
    private User guest;
    private Property property;
//    private List<Room> rooms;
//    private Room searchRoom;

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
	
	
	@DeleteMapping("/deleteres/{id}")
	public void deleteRes(@PathVariable("id") long id) {
		ReservationService.deleteRes(id);
	}
	
	@GetMapping("/reslist")
	@ResponseBody
	public List<Reservation> getReservations() {
		List<Reservation> list = ReservationService.getAllReservations();
		return list;
	}


	@GetMapping("/reservations/{fvid}")
	@ResponseBody
	public Reservation getEmployee(@PathVariable("fvid") Long resId) {
		return ReservationService.findByIdd(resId);
	}
	
	@PutMapping("/updateres")
	@ResponseBody
	public Reservation updateRes(@RequestBody Reservation res) {
	return ReservationService.updateRes(res);
	}


    @GetMapping(value = "findResByU/{Uid}")
    @ResponseBody
	public List<Reservation> findAllReservationByUser(@PathVariable("Uid") int Uid) {

		return ReservationService.findAllReservationByUser(Uid);
	}
	
	
	
}
