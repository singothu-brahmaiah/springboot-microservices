package com.api.foodorder.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import com.api.foodorder.entity.OrderDetails;
import com.api.foodorder.feignclient.CallToBankApplication;
import com.api.foodorder.model.FoodOrder;
import com.api.foodorder.model.FoodOrderRequest;
import com.api.foodorder.model.FoodOrderResponse;
import com.api.foodorder.model.OrderHistoryResponse;
import com.api.foodorder.repository.FoodOrderHistoryRepository;
import com.api.foodorder.repository.FoodOrderRespository;
import com.api.foodorder.service.FoodOrderService;

public class FoodOrderServiceImpl implements FoodOrderService {

	@Autowired
	FoodOrderHistoryRepository foodOrderHistoryRepository;

	@Autowired
	FoodOrderRespository foodOrderRespository;
	
	@Autowired
	CallToBankApplication callToBankApplication;

	static Map<String, String> vendorAccMap = new HashMap<String, String>();

	static {
		vendorAccMap.put("shop1", "1063399033");
		vendorAccMap.put("shop2", "2026240484");
	}

	
	@Override
	public List<OrderHistoryResponse> getOrderHistory() {
		List<OrderHistoryResponse> orderHistoryResponseList = new ArrayList<OrderHistoryResponse>();
		List<OrderDetails> orderListTemp = foodOrderHistoryRepository.findAll(Sort.by("updatedDate").descending());
		List<OrderDetails> orderDetailList = orderListTemp.stream().limit(5).collect(Collectors.toList());
		for (OrderDetails orderDetail : orderDetailList) {
			OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
			orderHistoryResponse.setOrderId(orderDetail.getOrderId());
			orderHistoryResponse.setItemId(orderDetail.getItemId());
			orderHistoryResponse.setItemName(orderDetail.getItemName());
			orderHistoryResponse.setPrice(orderDetail.getPrice());
			orderHistoryResponse.setOrderQty(orderDetail.getQuantity());
			orderHistoryResponse.setVendorName(orderDetail.getVendorName());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			orderHistoryResponse.setOrderTime(formatter.format(orderDetail.getUpdatedDate()));
			orderHistoryResponseList.add(orderHistoryResponse);
		}
		return orderHistoryResponseList;
	}

	@Override
	public List<FoodOrderResponse> foodOrder(List<FoodOrderRequest> foodOrderRequestList, String fromAccNum) {
		List<FoodOrderResponse> foodOrderResponseList = new ArrayList<FoodOrderResponse>();
		for (FoodOrderRequest foodOrderRequest : foodOrderRequestList) {
			FoodOrder foodOrder = foodOrderRespository.findByItemId(Long.valueOf(foodOrderRequest.getItemId()));
			if (foodOrder != null) {
				int availQty = Integer.valueOf(foodOrder.getQuantityAvailable())
						- Integer.valueOf(foodOrderRequest.getOrderQty());
				foodOrder.setQuantityAvailable(String.valueOf(availQty));
				foodOrderRespository.save(foodOrder);
			}
			OrderDetails orderHistory = new OrderDetails();
			int orderid = genOrderId();
			String orderIdTmp = String.valueOf(orderid).replaceAll("-", "");
			orderHistory.setOrderId(Integer.valueOf(orderIdTmp));
			orderHistory.setItemId(foodOrderRequest.getItemId());
			orderHistory.setItemName(foodOrderRequest.getItemName());
			orderHistory.setPrice(foodOrderRequest.getPrice());
			orderHistory.setQuantity(foodOrderRequest.getOrderQty());
			orderHistory.setVendorName(foodOrderRequest.getVendorName());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date date = new Date();
			String dateStr = formatter.format(date);
			try {
				orderHistory.setUpdatedDate(formatter.parse(dateStr));
			} catch (ParseException e) {
			}
			foodOrderHistoryRepository.save(orderHistory);
		}
		String totalAmount = getTotalAmount(foodOrderRequestList);
		FoodOrderResponse foodOrderResponse = new FoodOrderResponse();
		foodOrderResponse.setFoodOrderRequest(foodOrderRequestList);
		foodOrderResponse.setTotalAmount(totalAmount);
		foodOrderResponseList.add(foodOrderResponse);
		String paymentStatus = callToBankApplication.completePayment(fromAccNum, "1063399033", totalAmount);
		return foodOrderResponseList;
	}

	private String getTotalAmount(List<FoodOrderRequest> foodOrderRequestList) {
		String totalStr = "0";
		int total = 0;
		for (FoodOrderRequest foodOrderRequest : foodOrderRequestList) {
			total += Integer.valueOf(foodOrderRequest.getPrice()) * Integer.valueOf(foodOrderRequest.getOrderQty());
		}
		totalStr = String.valueOf(total);
		return totalStr;
	}

	public int genOrderId() {
		Random r = new Random(System.currentTimeMillis());
		return 1000000000 + r.nextInt(2000000000);
	}

}
