package tn.esprit.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Item;
import tn.esprit.spring.repository.ItemRepository;

@Service
public class ItemService implements ItemServiceInterface{
	@Autowired
	ItemRepository itemrepository;
	
	public void addNewItem(Item item){
		itemrepository.save(item);
	}
	public Optional<Item> getItemById(long id){
		return itemrepository.findById(id);
	}
}
