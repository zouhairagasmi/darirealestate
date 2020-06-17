package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Item implements Serializable{

	private static final long serialVersionUID = 6654332526918890010L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ItemId;
    @OneToMany(mappedBy = "item",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Orders> orderlist;
    @ManyToOne()
    @JoinColumn(name = "owner_id")
	private User user;
	private String ItemName;
	private String Description;
	private double Price;
	private int AvailableQuantity;
	private double shippingWeight;
	private String location;
	@Enumerated(value = EnumType.STRING)
	private Category category;
	private String pic;
	public Item() {
		super();
	}

	public Item(User user, String itemName, String description, double price, int availableQuantity,String location,String pic,
			double shippingWeight, Category category) {
		super();
		this.user = user;
		ItemName = itemName;
		Description = description;
		Price = price;
		AvailableQuantity = availableQuantity;
		this.shippingWeight = shippingWeight;
		this.category = category;
		this.location = location;
		this.pic =pic;
	}
	public Item(long ItemId,User user, String itemName, String description, double price, int availableQuantity,String location,String pic,
			double shippingWeight, Category category) {
		super();
		this.ItemId = ItemId;
		this.user = user;
		ItemName = itemName;
		Description = description;
		Price = price;
		AvailableQuantity = availableQuantity;
		this.shippingWeight = shippingWeight;
		this.category = category;
		this.location = location;
		this.pic =pic;
	}



	public long getItemId() {
		return ItemId;
	}

	public void setItemId(long itemId) {
		ItemId = itemId;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getAvailableQuantity() {
		return AvailableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		AvailableQuantity = availableQuantity;
	}

	public double getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AvailableQuantity;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + (int) (ItemId ^ (ItemId >>> 32));
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		temp = Double.doubleToLongBits(shippingWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Item other = (Item) obj;
		if (AvailableQuantity != other.AvailableQuantity)
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (ItemId != other.ItemId)
			return false;
		if (ItemName == null) {
			if (other.ItemName != null)
				return false;
		} else if (!ItemName.equals(other.ItemName))
			return false;
		if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
			return false;
		if (category != other.category)
			return false;
		if (Double.doubleToLongBits(shippingWeight) != Double.doubleToLongBits(other.shippingWeight))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Item [ItemId=" + ItemId + ", orderlist=" + orderlist + ", user=" + user + ", ItemName=" + ItemName
				+ ", Description=" + Description + ", Price=" + Price + ", AvailableQuantity=" + AvailableQuantity
				+ ", shippingWeight=" + shippingWeight + ", location=" + location + ", category=" + category + "]";
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
