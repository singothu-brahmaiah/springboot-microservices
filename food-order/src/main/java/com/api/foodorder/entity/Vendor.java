package com.api.foodorder.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VENDOR")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VENDOR_ID")
	private Integer id;

	@Column(name = "VENDOR_NAME")
	private String vendorName;

	@Column(name = "VENDOR_PHONE")
	private String phoneNumber;

	@Column(name = "VENDOR_ADDRESS")
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
