package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return itemservice.addNewItem(item);
	}

	@GetMapping("/getitem/{id}")
	public ResponseEntity<?> getitembyid(@PathVariable Long id) {
		Optional<Item> item = itemservice.getItemById(id);
		if (item.isPresent() == false) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Item>>(item, HttpStatus.OK);
	}

	@PutMapping("/updateitem")
	@ResponseBody
	public Item updateitem(@RequestBody Item item) {
		return itemservice.updateItem(item);
	}

	@DeleteMapping("/deleteitem/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") long id) {
		itemservice.deleteItem(id);
	}

	@GetMapping("/getallitems")
	@ResponseBody
	public ResponseEntity<List<Item>> getallitems() {
		List<Item> items = itemservice.getAllItems();
		if (items.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

	}
}
