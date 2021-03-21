package com.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddFoodDTO;
import com.app.dtos.RestDTO;
import com.app.dtos.UpdateFoodDTO;
import com.app.pojos.Category;
import com.app.pojos.Foods;
import com.app.pojos.Restaurant;
import com.app.service.ICategoryService;
import com.app.service.IFoodService;
import com.app.service.IOrderService;
import com.app.service.IRestaurantService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private IRestaurantService restService;
	@Autowired
	private ICategoryService catService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IFoodService foodService;

	public RestaurantController() {
		System.out.println("in ctr of " + getClass().getName());
	}

	@PutMapping("/{restId}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int restId, @RequestBody RestDTO restDTO) {
		System.out.println("in update details: " + restId + " " + restDTO);
		return new ResponseEntity<>(restService.updateVendorDetails(restId, restDTO), HttpStatus.OK);
	}

	@PostMapping("/{rest_id}")
	public ResponseEntity<?> addNewFood(@RequestBody AddFoodDTO newFood, @PathVariable("rest_id") int restId) {
		System.out.println(" in add new food controller method " + newFood);
		Foods food = new Foods();
		BeanUtils.copyProperties(newFood, food);
		System.out.println(" food after copying " + food);
		Restaurant rest = restService.findByRestId(restId);
		System.out.println(" category in dto is " + newFood.getCategory());
		Category category = catService.findByCatName(newFood.getCategory());
		return new ResponseEntity<>(restService.addFoods(food, rest, category), HttpStatus.ACCEPTED);
	}

	@PutMapping("/{rest_id}/foods/{food_id}")
	public ResponseEntity<?> updateFoodDetails (@PathVariable("rest_id") int restId, @PathVariable("food_id") int foodId ,@RequestBody UpdateFoodDTO foodDto) {
		System.out.println(" in update food details method of controller  "+restId+" "+foodDto);
		return new ResponseEntity<>(restService.updateFoodDetails(foodDto, restId, foodId), HttpStatus.ACCEPTED);
	}

	@GetMapping("/orderDetails/{restId}")
	public ResponseEntity<?> getAllOrdersToVendor(@PathVariable Restaurant restId) {
		System.out.println("in order details to vendor: " + restId);
		return new ResponseEntity<>(orderService.getAllOrdersToVendor(restId), HttpStatus.OK);
	}

	@DeleteMapping("/{rest_id}/foods/{food_id}")
	public ResponseEntity<?> deleteFoodFromMenu(@PathVariable("rest_id") int restId,
			@PathVariable("food_id") int foodId) {
		System.out.println(" in controller of delete food from menu " + restId + " " + foodId);
		return new ResponseEntity<>(restService.deleteFoodFromMenu(restId, foodId), HttpStatus.OK);
	}

	@PutMapping("/{order_id}/accept")
	public ResponseEntity<?> acceptOrder(@PathVariable int orderId) {
		System.out.println(" in accept order method of controller  ");
		return new ResponseEntity<>(restService.acceptIncomingOrder(orderId), HttpStatus.ACCEPTED);
	}

	@PutMapping("/{order_id}/decline")
	public ResponseEntity<?> declineOrder(@PathVariable int orderId) {
		System.out.println(" in accept order method of controller  ");
		return new ResponseEntity<>(restService.declineIncomingOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/{rest_id}")
	public ResponseEntity<?> getAllFood(@PathVariable("rest_id") Restaurant restId) {
		System.out.println(" in food details method of controller  "+restId);
		return new ResponseEntity<>(foodService.getAllFood(restId), HttpStatus.ACCEPTED);
	}
}
