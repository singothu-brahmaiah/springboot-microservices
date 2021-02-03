package com.api.foodorder.service;

import java.util.List;

import javax.validation.Valid;

import com.api.foodorder.model.MenuItemsDetailResponse;

public interface MenuItemService {

	List<MenuItemsDetailResponse> getItemDetails(@Valid String itenName);

}
