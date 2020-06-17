package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orders implements Serializable {

	private static final long serialVersionUID = 4318223333966861878L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long OrderId;
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "item_id")
	private Item item;
	@ManyToOne()
	@JoinColumn(name = "buyer_id")
	private User user1;
	private int quantity;
	private Date datecreated;
	private Date Maxdatedelivery;
	private double shippingprice;
	private String shippingdestination;
	private double distance;
	private double totalprice;
	@Enumerated(value = EnumType.STRING)
	private Status status;
	@Enumerated(value = EnumType.STRING)
	private Deliverytype deliverytype;

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public Orders() {
		super();
	}

	public Orders(Item item, User user1, int quantity, Date datecreated, double shippingprice,
			String shippingdestination, double distance, double totalprice, Status status, Deliverytype deliverytype) {
		super();
		this.item = item;
		this.user1 = user1;
		this.quantity = quantity;
		this.datecreated = datecreated;
		this.shippingprice = shippingprice;
		this.shippingdestination = shippingdestination;
		this.distance = distance;
		this.totalprice = totalprice;
		this.status = status;
		this.deliverytype = deliverytype;
	}

	public Orders(Item item, User user1, int quantity, String shippingdestination, Deliverytype deliverytype) {
		super();
		this.item = item;
		this.user1 = user1;
		this.quantity = quantity;
		this.shippingdestination = shippingdestination;
		this.deliverytype = deliverytype;
	}
	public Orders(long OrderId,Item item, User user1, int quantity, String shippingdestination, Deliverytype deliverytype) {
		super();
		this.item = item;
		this.user1 = user1;
		this.quantity = quantity;
		this.shippingdestination = shippingdestination;
		this.deliverytype = deliverytype;
		this.OrderId = OrderId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getOrderId() {
		return OrderId;
	}

	public void setOrderId(long orderId) {
		OrderId = orderId;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public double getShippingprice() {
		return shippingprice;
	}

	public void setShippingprice(double shippingprice) {
		this.shippingprice = shippingprice;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getMaxdatedelivery() {
		return Maxdatedelivery;
	}

	public void setMaxdatedelivery(Date maxdatedelivery) {
		Maxdatedelivery = maxdatedelivery;
	}

	public Deliverytype getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(Deliverytype deliverytype) {
		this.deliverytype = deliverytype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Maxdatedelivery == null) ? 0 : Maxdatedelivery.hashCode());
		result = prime * result + (int) (OrderId ^ (OrderId >>> 32));
		result = prime * result + ((datecreated == null) ? 0 : datecreated.hashCode());
		result = prime * result + ((deliverytype == null) ? 0 : deliverytype.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((shippingdestination == null) ? 0 : shippingdestination.hashCode());
		temp = Double.doubleToLongBits(shippingprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(totalprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user1 == null) ? 0 : user1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (Maxdatedelivery == null) {
			if (other.Maxdatedelivery != null)
				return false;
		} else if (!Maxdatedelivery.equals(other.Maxdatedelivery))
			return false;
		if (OrderId != other.OrderId)
			return false;
		if (datecreated == null) {
			if (other.datecreated != null)
				return false;
		} else if (!datecreated.equals(other.datecreated))
			return false;
		if (deliverytype != other.deliverytype)
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		if (shippingdestination == null) {
			if (other.shippingdestination != null)
				return false;
		} else if (!shippingdestination.equals(other.shippingdestination))
			return false;
		if (Double.doubleToLongBits(shippingprice) != Double.doubleToLongBits(other.shippingprice))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(totalprice) != Double.doubleToLongBits(other.totalprice))
			return false;
		if (user1 == null) {
			if (other.user1 != null)
				return false;
		} else if (!user1.equals(other.user1))
			return false;
		return true;
	}

}
