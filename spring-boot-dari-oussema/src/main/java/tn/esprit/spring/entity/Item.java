package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ItemId;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User user;
	private String ItemName;
	// @Column(columnDefinition="text")
	private String Description;
	private double Price;
	private int AvailableQuantity;
	private double shippingWeight;
	// @Transient
	// private MultipartFile Picture;
	@Enumerated(value = EnumType.STRING)
	private Category category;
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<CartItem> CartItemList;

	public Item() {
		super();
	}
	
	public Item(String itemn, String description, double price, int availableQuantity, double shippingWeight,
			Category category) {
		this.ItemName = itemn;
		this.Description = description;
		this.Price = price;
		this.AvailableQuantity = availableQuantity;
		this.shippingWeight = shippingWeight;
		this.category = category;
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

	public List<CartItem> getCartItemList() {
		return CartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		CartItemList = cartItemList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
