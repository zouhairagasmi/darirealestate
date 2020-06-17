
package tn.esprit.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entity.Deliverytype;
import tn.esprit.spring.entity.Item;
import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ItemServiceInterface;
import tn.esprit.spring.service.OrderServiceInterface;

@Scope(value = "session")
@Controller(value = "orderController")
@ELBeanName(value = "orderController")
public class OrderController {
	@Autowired
	OrderServiceInterface orderservice;
	@Autowired
	ItemServiceInterface itemservice;
	private User Current = UserJsfController.user;
	private long idi;
	private int quantity;
	private String shippingdestination;
	private Deliverytype deliverytype;
	private List<Orders> orders;
	private long orderid;
	private double Distance;
	private String from;
	private String pic;
	List<Integer> range;
	public Deliverytype[] getDeliverytypes() {
		return Deliverytype.values();
	}

	public String addorder() {
		Item item = itemservice.getItemById(idi).get();
		orderservice.addNewOrder(new Orders(item, Current, quantity, shippingdestination, deliverytype));
		return "myorders?faces-redirect=true";
	}
	public String buyitem(Item item) {
		this.setIdi(item.getItemId());
		this.setQuantity(item.getAvailableQuantity());
		this.setRange(IntStream.rangeClosed(1, quantity)
			    .boxed().collect(Collectors.toList()));
		return "addorder?faces-redirect=true";
	}
	public void deleteorder(long id) {
		orderservice.deleteOrder(id);
	}

	public String displayorder(Orders o) {
		this.setCurrent(o.getUser1());
		this.setIdi(o.getItem().getItemId());
		Item item = itemservice.getItemById(idi).get();
		this.setQuantity(item.getAvailableQuantity());
		this.setRange(IntStream.rangeClosed(1, quantity)
			    .boxed().collect(Collectors.toList()));
		this.setShippingdestination(o.getShippingdestination());
		this.setDeliverytype(o.getDeliverytype());
		this.setOrderid(o.getOrderId());
		return "addorder?faces-redirect=true";
	}

	public String updateorder() {
		Item item = itemservice.getItemById(idi).get();
		orderservice.updateOrder(new Orders(orderid, item, Current, quantity, shippingdestination, deliverytype));
		return "myorders?faces-redirect=true";
	}

	public OrderServiceInterface getOrderservice() {
		return orderservice;
	}

	public void setOrderservice(OrderServiceInterface orderservice) {
		this.orderservice = orderservice;
	}

	public User getCurrent() {
		return Current;
	}

	public void setCurrent(User current) {
		Current = current;
	}

	public long getIdi() {
		return idi;
	}

	public void setIdi(long idi) {
		this.idi = idi;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShippingdestination() {
		return shippingdestination;
	}

	public void setShippingdestination(String shippingdestination) {
		this.shippingdestination = shippingdestination;
	}

	public Deliverytype getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(Deliverytype deliverytype) {
		this.deliverytype = deliverytype;
	}

	public List<Orders> getOrders() {
		return orderservice.getAllOrders();
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}


	public double getDistance() {
		return Distance;
	}


	public void setDistance(double distance) {
		Distance = distance;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public List<Integer> getRange() {
		return range;
	}


	public void setRange(List<Integer> range) {
		this.range = range;
	}

}