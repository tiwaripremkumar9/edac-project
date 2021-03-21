package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.dtos.FoodCart;
import com.app.dtos.FoodList;
import com.app.pojos.Foods;

public interface ICartService {
	void addFood( int foodId);
	void removeProduct( int foodId);
	List<FoodCart> getFoodInCart();
	
	
}
