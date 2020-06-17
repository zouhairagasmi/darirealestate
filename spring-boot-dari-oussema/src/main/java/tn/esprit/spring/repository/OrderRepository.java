package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Orders;

public interface OrderRepository  extends CrudRepository<Orders, Long>  {

}
