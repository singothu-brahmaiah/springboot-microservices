package com.api.foodorder.service;

import java.util.List;

import com.api.foodorder.model.FoodOrderRequest;
import com.api.foodorder.model.FoodOrderResponse;
import com.api.foodorder.model.OrderHistoryResponse;

public interface FoodOrderService {

	public List<OrderHistoryResponse> getOrderHistory();

	public List<FoodOrderResponse> foodOrder(List<FoodOrderRequest> foodOrderRequest, String fromAccNum);

}
