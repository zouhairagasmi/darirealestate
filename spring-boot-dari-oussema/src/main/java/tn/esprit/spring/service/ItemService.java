package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Item;
import tn.esprit.spring.repository.ItemRepository;

@Service
public class ItemService implements ItemServiceInterface{
	@Autowired
	ItemRepository itemrepository;
	public Item addNewItem(Item item){
		Item i=itemrepository.save(item);
		return i;
	}
}
