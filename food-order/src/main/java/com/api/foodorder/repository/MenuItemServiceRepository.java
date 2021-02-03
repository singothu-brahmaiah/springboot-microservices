package com.api.foodorder.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.foodorder.entity.MenuItems;

@Repository
public interface MenuItemServiceRepository extends JpaRepository<MenuItems, Integer> {

	public List<MenuItems> findByItemNameContains(@Valid @Param("itemName") String itemName);

	public MenuItems findByItemId();
	
	MenuItems findByItemId(Long itemId);


}
