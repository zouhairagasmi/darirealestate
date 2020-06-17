package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Orders;

public interface OrderServiceInterface {

	public long addNewOrder(Orders orders);
	public Optional<Orders> getOrderById(long id);
	public Orders updateOrder(Orders orders);
	public void deleteOrder(long id);
	public List<Orders> getAllOrders();

}
