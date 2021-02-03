package com.api.foodorder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class FoodOrder implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "vendor_name")
	private String vendorName;

	@Column(name = "price")
	private String price;
	
	@Column(name = "quantity_available")
	private String quantityAvailable;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(String quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	
}
