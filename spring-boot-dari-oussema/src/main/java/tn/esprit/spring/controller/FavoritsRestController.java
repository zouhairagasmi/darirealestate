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

import tn.esprit.spring.entity.Favorits;
import tn.esprit.spring.interfaces.IFavoritsService;

@RestController
public class FavoritsRestController {

	@Autowired
	IFavoritsService favoritsService;

	// http://localhost:8088/SpringRegister/servlet/
	@RequestMapping("/")
	@ResponseWrapper
		public String welcome() { return "welcome"; }
	
	


	@GetMapping("/favoritslist")
	@ResponseBody
	public List<Favorits> getFavorits() {
		List<Favorits> list = favoritsService.getAllFavorits();
		return list;
	}


	@GetMapping("/favorit/{fvid}")
	@ResponseBody
	public Favorits getEmployee(@PathVariable("fvid") Long fvId) {
		return favoritsService.findByIdd(fvId);
	}


	@PostMapping("/addfavorit")
	@ResponseBody
	public Favorits addUser(@RequestBody Favorits fv) {
		Favorits favorit = favoritsService.addFavorit(fv);
		return favorit;
	}



	@DeleteMapping("/deletefav/{id}")
	public void deleteFav(@PathVariable("id") long id) {
		favoritsService.deleteFavorit(id);
	}
	


	@PutMapping("/updatefav")
	@ResponseBody
	public Favorits updateFavorit(@RequestBody Favorits favorit) {
	return favoritsService.updateFavorit(favorit);
	}


}
