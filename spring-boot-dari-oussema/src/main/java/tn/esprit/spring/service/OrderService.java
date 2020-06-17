package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.controller.DistanceController;
import tn.esprit.spring.entity.Deliverytype;
import tn.esprit.spring.entity.Item;
import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.Status;
import tn.esprit.spring.repository.ItemRepository;
import tn.esprit.spring.repository.OrderRepository;

@Service
public class OrderService implements OrderServiceInterface {
	@Autowired
	OrderRepository orderrepository;
	@Autowired
	ItemServiceInterface itemservice;
	@Autowired
	ItemRepository itemrepository;
	@Override
	public long addNewOrder(Orders orders) {
		Date dt=new java.util.Date();
		Item i=itemservice.getItemById(orders.getItem().getItemId()).get();
		orders.setDatecreated(dt);
		GenerateDeliveryDate(orders);
		UpdateStatus(orders);
		orders.setDistance(DistanceController.callapi(i.getLocation(), orders.getShippingdestination()));
		orders.setShippingprice(GenerateShippingPrice(orders,i.getShippingWeight()));
		orders.setTotalprice(orders.getShippingprice() + i.getPrice() * orders.getQuantity());
		i.setAvailableQuantity(i.getAvailableQuantity() - orders.getQuantity());
		itemrepository.save(i);
		orderrepository.save(orders);
		return orders.getOrderId();
	}
	public void GenerateDeliveryDate(Orders orders) {
		Date dt=new java.util.Date();  
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		if (orders.getDeliverytype().toString()=="fast")
			c.add(Calendar.DATE, 3);
		else
			c.add(Calendar.DATE, 10);
		dt = c.getTime();
		orders.setMaxdatedelivery(dt);
	}
	public void UpdateStatus(Orders orders) {
		Date dt=new java.util.Date();
		if(orders.getMaxdatedelivery()==dt) 
			orders.setStatus(Status.Delivered);
		else
			orders.setStatus(Status.Waiting);
	}
	public double GenerateShippingPrice(Orders orders,double sw) {
		double sp =5;
		double totalsw=orders.getQuantity()*sw;
		if (totalsw>10)
			sp=sp+(totalsw/10)*0.5;
		else
			sp=sp+0.5;
		if (orders.getDeliverytype()==Deliverytype.fast)
			sp=sp+5;
		if (orders.getDistance()>5)
			sp=sp+(orders.getDistance()/10)*2;
		else
			sp=sp+2;
		return Math.round(sp * 100.0) / 100.0;
	}

	public Optional<Orders> getOrderById(long id) {
		return orderrepository.findById(id);
	}

	public Orders updateOrder(Orders orders) {
		orders.setOrderId(orders.getOrderId());
		System.out.println("id="+orders.getOrderId());
		Date dt=new java.util.Date();
		Item i=itemservice.getItemById(orders.getItem().getItemId()).get();
		orders.setDatecreated(dt);
		GenerateDeliveryDate(orders);
		UpdateStatus(orders);
		orders.setDistance(DistanceController.callapi(i.getLocation(), orders.getShippingdestination()));
		orders.setShippingprice(GenerateShippingPrice(orders,i.getShippingWeight()));
		orders.setTotalprice(orders.getShippingprice() + i.getPrice() * orders.getQuantity());
		i.setAvailableQuantity(i.getAvailableQuantity() - orders.getQuantity());
		itemrepository.save(i);
		return orderrepository.save(orders);
	}

	public void deleteOrder(long id) {
		orderrepository.deleteById(id);
	}

	public List<Orders> getAllOrders() {
		return (List<Orders>) orderrepository.findAll();
	}

}
