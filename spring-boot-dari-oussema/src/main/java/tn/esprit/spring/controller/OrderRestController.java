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

import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.service.OrderServiceInterface;


@RestController//same as @Controller and @ResponseBody together(@controller:marks the class as a web controller, capable of handling the HTTP requests.)
public class OrderRestController {
	@Autowired
	OrderServiceInterface orderservice;

	@PostMapping("/addorder")
	//@ResponseBody//convert your objects into JSON(commented because we are using restcontroller)sss
	public long addneworder(@RequestBody Orders orders) {
		return orderservice.addNewOrder(orders);
	}

	@GetMapping("/getorder/{id}")
	public ResponseEntity<?> getorderbyid(@PathVariable Long id) {
		Optional<Orders> orders = orderservice.getOrderById(id);
		if (orders.isPresent() == false) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Orders>>(orders, HttpStatus.OK);
	}

	@PutMapping("/updateorder")
	public Orders updateorder(@RequestBody Orders orders) {
		return orderservice.updateOrder(orders);
	}

	@DeleteMapping("/deleteorder/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		orderservice.deleteOrder(id);
	}

	@GetMapping("/getallorders")
	public ResponseEntity<List<Orders>> getallorders() {
		List<Orders> orders = orderservice.getAllOrders();
		if (orders.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);

	}
}
