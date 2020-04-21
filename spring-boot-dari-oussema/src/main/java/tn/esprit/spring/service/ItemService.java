package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Item;
import tn.esprit.spring.repository.ItemRepository;

@Service
public class ItemService implements ItemServiceInterface {
	@Autowired
	ItemRepository itemrepository;

	public Item addNewItem(Item item) {
		return itemrepository.save(item);
	}

	public Optional<Item> getItemById(long id) {
		return itemrepository.findById(id);
	}

	public Item updateItem(Item item) {
		item.setAvailableQuantity(item.getAvailableQuantity());
		item.setCategory(item.getCategory());
		item.setDescription(item.getDescription());
		item.setItemId(item.getItemId());
		item.setItemName(item.getItemName());
		item.setPrice(item.getPrice());
		item.setShippingWeight(item.getShippingWeight());
		item.setUser(item.getUser());
		return itemrepository.save(item);
	}

	public void deleteItem(long id) {
		itemrepository.deleteById(id);
	}

	public List<Item> getAllItems() {
		return (List<Item>) itemrepository.findAll();
	}

}
