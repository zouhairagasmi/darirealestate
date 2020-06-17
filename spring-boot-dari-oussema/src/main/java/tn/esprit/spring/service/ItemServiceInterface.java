package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Item;

public interface ItemServiceInterface {
	public long addNewItem(Item item);

	public Optional<Item> getItemById(long id);

	public Item updateItem(Item item);

	public void deleteItem(long id);

	public List<Item> getAllItems();

}
