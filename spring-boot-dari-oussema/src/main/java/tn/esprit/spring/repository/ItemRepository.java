package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Item;

public interface ItemRepository  extends CrudRepository<Item, Long>  {

}
