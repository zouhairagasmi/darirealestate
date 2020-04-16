package tn.esprit.spring.service;

import java.util.Optional;

import tn.esprit.spring.entity.Item;

public interface ItemServiceInterface {
	public void addNewItem(Item item);
	public Optional<Item> getItemById(long id);

}
