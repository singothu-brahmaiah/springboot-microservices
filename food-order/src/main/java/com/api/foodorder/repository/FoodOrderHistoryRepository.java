package com.api.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.foodorder.entity.OrderDetails;

@Repository
public interface FoodOrderHistoryRepository extends JpaRepository<OrderDetails, Integer>{

}
