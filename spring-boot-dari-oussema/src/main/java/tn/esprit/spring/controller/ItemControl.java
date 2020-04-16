package tn.esprit.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Item;
import tn.esprit.spring.service.ItemServiceInterface;

@RestController
public class ItemControl {
	@Autowired
	ItemServiceInterface itemservice;

	@PostMapping("/additem")
	@ResponseBody
	public Item addnewitem(@RequestBody Item item) {
		itemservice.addNewItem(item);
		return item;
	}

	@GetMapping("/getitem/{id}")
	public Optional<Item> getitembyid(@PathVariable Long id) {
		return itemservice.getItemById(id);
	}
}
