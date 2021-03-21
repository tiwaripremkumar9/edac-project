package com.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.app.dtos.RestDTO;
import com.app.dtos.UpdateFoodDTO;
import com.app.pojos.Category;
import com.app.pojos.Foods;
import com.app.pojos.Restaurant;

public interface IRestaurantService {
	Restaurant addNewRestaurant(Restaurant rest);

	String deleteRestaurant(int restId);

	List<Restaurant> findByName(String Name);

	Restaurant updateVendorDetails(int restId, RestDTO restDTO);

	List<Restaurant> displayRestaurants(String pincode);
	
	Foods addFoods(Foods foods, Restaurant restaurant, Category category);
	
	String updateFoodDetails(UpdateFoodDTO foodDTO, int restId, int foodId);

	String deleteFoodFromMenu(int restId, int foodId);

	String  acceptIncomingOrder(int id);
	
	String declineIncomingOrder(int id);

	String addAddress(int id, String address);
	Restaurant authenticateRest(String email, String password);

	@Query("select r.id , r.name, r.email, r.mob, r.pincode from Restaurant r")
	List<Restaurant> restList();

	Restaurant findByRestId(int id);
	
	List<Restaurant> getAllRestaurant();

	int restcount();

}
