package com.api.foodorder.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.foodorder.entity.MenuItems;
import com.api.foodorder.entity.Vendor;
import com.api.foodorder.model.MenuItemsDetailResponse;
import com.api.foodorder.repository.MenuItemServiceRepository;
import com.api.foodorder.repository.VendorServiceRepository;
import com.api.foodorder.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	MenuItemServiceRepository menuItemServiceRepository;

	@Autowired
	VendorServiceRepository vendorServiceRepository;

	@Override
	public List<MenuItemsDetailResponse> getItemDetails(@Valid String itemName) {
		List<MenuItems> menuItems = menuItemServiceRepository.findByItemNameContains(itemName);

		return menuItems.stream().map(this::getMenuItemsDetailResponse).collect(Collectors.toList());
	}

	public MenuItemsDetailResponse getMenuItemsDetailResponse(MenuItems menuItems) {
		Optional<Vendor> vendor = vendorServiceRepository.findById(menuItems.getVendorId());

		MenuItemsDetailResponse menuItemsDetailResponse = new MenuItemsDetailResponse();
		menuItemsDetailResponse.setItemId(menuItems.getItemId());
		menuItemsDetailResponse.setItemName(menuItems.getItemName());
		menuItemsDetailResponse.setVendorId(menuItems.getVendorId());
		menuItemsDetailResponse.setCategory(menuItems.getItemCategory());
		menuItemsDetailResponse.setPrice(menuItems.getItemPrice());
		menuItemsDetailResponse.setVendorName(vendor.get().getVendorName());
		menuItemsDetailResponse.setVendorId(vendor.get().getId());

		return menuItemsDetailResponse;

	}
	
	
	

}
