package com.api.foodorder.model;

import java.io.Serializable;
import java.util.List;

public class FoodOrderResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FoodOrderRequest> foodOrderRequest;
	
	private String totalAmount;

	public List<FoodOrderRequest> getFoodOrderRequest() {
		return foodOrderRequest;
	}

	public void setFoodOrderRequest(List<FoodOrderRequest> foodOrderRequest) {
		this.foodOrderRequest = foodOrderRequest;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	
}
