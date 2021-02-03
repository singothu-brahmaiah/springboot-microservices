package com.api.foodorder.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_ITEMS")
public class MenuItems implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID")
	private Integer itemId;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "ITEM_PRICE")
	private Double itemPrice;
	@Column(name = "ITEM_CATEGORY")
	private String itemCategory;
	@Column(name = "VENDOR_ID")
	private Integer vendorId;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

}
