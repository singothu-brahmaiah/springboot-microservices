package com.api.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.foodorder.model.FoodOrder;

public interface FoodOrderRespository extends JpaRepository<FoodOrder, Long>{

	FoodOrder findByItemId(Long itemId);
	
}
