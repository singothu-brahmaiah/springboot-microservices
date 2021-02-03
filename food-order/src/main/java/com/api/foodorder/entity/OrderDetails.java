package com.api.foodorder.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER-DETAIL")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "updated_Date")
	private Date updatedDate;

	@Id
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "price")
	private String price;

	@Column(name = "vendor_name")
	private String vendorName;

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date date) {
		this.updatedDate = date;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

}
