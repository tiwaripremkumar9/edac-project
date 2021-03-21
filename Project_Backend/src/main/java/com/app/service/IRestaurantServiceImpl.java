package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excs.ResourceNotFoundException;
import com.app.dao.AddressRepository;
import com.app.dao.FoodRepository;
import com.app.dao.OrderRepository;
import com.app.dao.RestaurantRepository;
import com.app.dtos.RestDTO;
import com.app.dtos.UpdateFoodDTO;
import com.app.pojos.Address;
import com.app.pojos.Category;
import com.app.pojos.Foods;
import com.app.pojos.Order;
import com.app.pojos.OrderStatus;
import com.app.pojos.Restaurant;

@Service
@Transactional
public class IRestaurantServiceImpl implements IRestaurantService {

	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private FoodRepository foodRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private AddressRepository addRepo;

	@Override
	public Restaurant addNewRestaurant(Restaurant rest) {
		System.out.println("in service of rest: "+ rest);
		System.out.println("rest"+ rest.getId());
		return restRepo.save(rest);
	}
	@Override
	public String deleteRestaurant(int restId) {
		boolean exists = restRepo.existsById(restId);
		if (!exists)
			throw new ResourceNotFoundException("Invalid user id!!!!!");
		restRepo.deleteById(restId);
		return "Restaurant with Id"+restId+"deleted";
	}
	@Override
	public List<Restaurant> findByName(String Name) {
		return restRepo.findByName(Name);
	}
	@Override
	public Restaurant updateVendorDetails(int restId, RestDTO restDTO) {
		System.out.println("in update "+restDTO);		
		Restaurant restDetails=restRepo.findById(restId);
		//System.out.println("restId " +restDetails.getId());
		System.out.println("user dtls from db "+restDetails);		
		BeanUtils.copyProperties(restDTO, restDetails, "email");
		System.out.println("updated vendor dtls "+restDetails);		
		return restDetails;		
	}

	@Override
	public List<Restaurant> displayRestaurants(String pincode) {
		System.out.println(" in display restaurant service method "+pincode);
		List<Restaurant> restList = restRepo.findByPincode(pincode);
		System.out.println("list of restaurants  "+restList);
		return restList;
	}
	@Override
	public Foods addFoods(Foods food, Restaurant restaurant, Category category) {
		food.setRestId(restaurant);
		food.setCategory(category);
		Foods foods = foodRepo.save(food);
		return foods;
	}
	@Override
	public Restaurant findByRestId(int id) {
		System.out.println(" in restauant find by id method "+id); 
		Restaurant rest = restRepo.findById(id);
		System.out.println(" restaurant found by id is :  "+rest); 
		return rest;
	}

	@Override
	public String updateFoodDetails( UpdateFoodDTO foodDTO, int restId, int foodId) {
		System.out.println(" in update food details of restaurant service "+restId+" "+foodDTO);
		Foods food = new Foods();
		BeanUtils.copyProperties(foodDTO,food);
		Foods persistedFood = foodRepo.findByRestIdAndId(foodId, restId);
		System.out.println("  persisted Food  "+persistedFood);
		System.out.println(" status dto  "+foodDTO.getFoodStatus());
		if(foodDTO.getFoodStatus().equalsIgnoreCase("Yes"))
			persistedFood.setFoodStatus(false);
		else
			persistedFood.setFoodStatus(true);
		System.out.println(" persisted status "+persistedFood.isFoodStatus());
		String message = "Food "+persistedFood.getName()+" details updated";
		if(persistedFood != null) {
			persistedFood.setName(food.getName());
			persistedFood.setPrice(food.getPrice());
			persistedFood.setDescription(food.getDescription());			
			foodRepo.save(persistedFood);
		}
		else {
			message = "Failed to update food details ";
		}
		return message;
	}

	@Override
	public String deleteFoodFromMenu(int restId, int foodId) {
		String message;
		System.out.println(" in del food from menu method of service  "+restId);
		Foods food = 	foodRepo.findByRestIdAndId(foodId, restId);
		if(food != null) {
			foodRepo.delete(food);
		 message = "Food "+food.getName()+" Deleted";
		}
		else
			message = "Food deletion failed";
		return message;
	}
	
	@Override
	public String acceptIncomingOrder( int id) {
		System.out.println(" in accept incoming order ");
		Order order = orderRepo.findById(id).get();
		String message = "order of "+order.getId()+" accepted ";
		if(order != null) {
		System.out.println(" order is:  "+order);
		order.setStatus(OrderStatus.ACCEPTED);
		System.out.println(" order status changed to  "+order.getStatus());
		return message="order status changed";
		}
		else
			return message = "changing order status failed";
	}
	
	@Override
	public String declineIncomingOrder( int id) {
		System.out.println(" in decline incoming order ");
		Order order = orderRepo.findById(id).get();
		String message = "order of "+order.getId()+" declined ";
		if(order != null) {
		System.out.println(" order is:  "+order);
		order.setStatus(OrderStatus.CANCELLED);
		System.out.println(" order status changed to  "+order.getStatus());
		}
		else
			message = "changing order status failed";
		return message;
	}

	@Override
	public String addAddress(int id, String newAddress) {
		String message = "Address accepted";
		System.out.println(" add address of user in service method  "+id+"  "+newAddress);
		Address address =addRepo.findByUserId(id);
		if(newAddress != null && address != null)
			address.setUserAddress(newAddress);
		else
			message = "Invalid Address";
		return message;
	}
	@Override
	public Restaurant authenticateRest(String email, String password) {
		System.out.println(" user credentials  "+restRepo.findByEmailAndPassword(email, password));
		return restRepo.findByEmailAndPassword(email, password);
	}
	@Override
	public List<Restaurant> restList() {
		return restRepo.findAll();
	}
	@Override
	public List<Restaurant> getAllRestaurant() {		
		return restRepo.findAll();
	}
	@Override
	public int restcount() {
		return (int) restRepo.count();
	}

	

}
