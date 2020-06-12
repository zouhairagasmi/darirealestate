package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Item;
import tn.esprit.spring.interfaces.IUserService;
import tn.esprit.spring.service.ItemServiceInterface;

@RestController // same as @Controller and @ResponseBody
				// together(@controller:marks the class as a web controller,
				// capable of handling the HTTP requests.)
public class ItemRestController {
	@Autowired
	ItemServiceInterface itemservice;
	@Autowired
	private IUserService us;

	/*
	 * @PostMapping("/additem") //@ResponseBody//convert your objects into
	 * JSON(commented because we are using restcontroller)sss public long
	 * addnewitem(@RequestBody Item item) { return itemservice.addNewItem(item);
	 * }
	 */
	@RequestMapping(value = "/additem", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public long addnewitem(@RequestParam("file") MultipartFile file, @RequestParam("user") long idu,
			@RequestParam("itemName") String itemname, @RequestParam("price") double price,
			@RequestParam("availableQuantity") int aq, @RequestParam("shippingWeight") double sw,
			@RequestParam("category") String cat, @RequestParam("description") String des,
			@RequestParam("location") String loc) throws IOException {
		File convertFile = new File(
				"C:/Users/Amine Masmoudi/git/darirealestate/spring-boot-dari-oussema/src/main/webapp/images/"
						+ file.getOriginalFilename());
		convertFile.createNewFile();

		try (FileOutputStream fout = new FileOutputStream(convertFile)) {
			fout.write(file.getBytes());
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		Item item = new Item();
		item.setUser(us.getUserById(idu));
		item.setItemName(itemname);
		item.setPrice(price);
		item.setAvailableQuantity(aq);
		item.setShippingWeight(sw);
		item.setCategory(Category.valueOf(cat));
		item.setDescription(des);
		item.setLocation(loc);
		item.setPic(file.getOriginalFilename());
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

	@RequestMapping(value = "/updateitem", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Item updateitem(@RequestParam("file") MultipartFile file, @RequestParam("user") long idu,
			@RequestParam("itemName") String itemname, @RequestParam("price") double price,
			@RequestParam("availableQuantity") int aq, @RequestParam("shippingWeight") double sw,
			@RequestParam("category") String cat, @RequestParam("description") String des,
			@RequestParam("location") String loc,@RequestParam("itemId") long idi) throws IOException {
		File convertFile = new File(
				"C:/Users/Amine Masmoudi/git/darirealestate/spring-boot-dari-oussema/src/main/webapp/images/"
						+ file.getOriginalFilename());
		convertFile.createNewFile();

		try (FileOutputStream fout = new FileOutputStream(convertFile)) {
			fout.write(file.getBytes());
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		Item item = new Item();
		item.setUser(us.getUserById(idu));
		item.setItemName(itemname);
		item.setPrice(price);
		item.setAvailableQuantity(aq);
		item.setShippingWeight(sw);
		item.setCategory(Category.valueOf(cat));
		item.setDescription(des);
		item.setLocation(loc);
		item.setPic(file.getOriginalFilename());
		item.setItemId(idi);
		return itemservice.updateItem(item);
	}

	@DeleteMapping("/deleteitem/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		itemservice.deleteItem(id);
	}

	@GetMapping("/getallitems")
	public ResponseEntity<List<Item>> getallitems() {
		List<Item> items = itemservice.getAllItems();
		if (items.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

	}
}
