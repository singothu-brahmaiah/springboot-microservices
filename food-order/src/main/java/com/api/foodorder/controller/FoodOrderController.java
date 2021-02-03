package com.api.foodorder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.foodorder.model.FoodOrderRequest;
import com.api.foodorder.model.FoodOrderResponse;
import com.api.foodorder.model.MenuItemsDetailResponse;
import com.api.foodorder.model.OrderHistoryResponse;
import com.api.foodorder.service.FoodOrderService;
import com.api.foodorder.service.MenuItemService;
import com.api.foodorder.service.VendorService;

@RestController
@RequestMapping("/food-order")
public class FoodOrderController {

	@Autowired
	VendorService VendorService;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	FoodOrderService foodOrderService;
	
	
	@GetMapping("/menuItems/searchByName")
	public ResponseEntity<List<MenuItemsDetailResponse>> getItemDetailResponse(@Valid @RequestParam String itemName) {

		return ResponseEntity.ok(menuItemService.getItemDetails(itemName));
	}
	
	
	@PostMapping(value = "/foodOrder")
	public ResponseEntity<List<FoodOrderResponse>> foodOrder(@RequestBody List<FoodOrderRequest> foodOrderVO, @RequestParam String fromAccNum) {	
		return ResponseEntity.ok(foodOrderService.foodOrder(foodOrderVO, fromAccNum));
	}
	
	
	@GetMapping("/orderHistoryTop5")
	public ResponseEntity<List<OrderHistoryResponse>> getOrderHistory() {	
		return ResponseEntity.ok(foodOrderService.getOrderHistory());
	}


}
