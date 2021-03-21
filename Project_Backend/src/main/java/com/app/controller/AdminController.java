package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Category;
import com.app.pojos.Restaurant;
import com.app.pojos.User;
import com.app.service.ICategoryService;
import com.app.service.IOrderService;
import com.app.service.IPaymentService;
import com.app.service.IRestaurantService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	@Autowired
	private IRestaurantService restService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICategoryService catService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IPaymentService payService;

	@PostMapping("/restRegister")
	public ResponseEntity<?> addNewRestaurant(@RequestBody Restaurant newRest) {
		System.out.println(" in add new rest" + newRest);
		return new ResponseEntity<>(restService.addNewRestaurant(newRest), HttpStatus.CREATED);
	}

	@DeleteMapping("/restaurant/{restId}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable int restId) {
		System.out.println("in delete restId" + restId);
		return ResponseEntity.ok(restService.deleteRestaurant(restId));
	}

	@PostMapping("/deliveryBoyRegister")
	public ResponseEntity<?> addNewDeliveryBoy(@RequestBody User newdeliveryBoy) {
		System.out.println("in add new deliveryBoy" + newdeliveryBoy);
		return new ResponseEntity<>(userService.addNewDeliveryBoy(newdeliveryBoy), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<?> deleteDeliveryBoy(@PathVariable("userId") int userId) {
		System.out.println("in delete restId " + userId);
		return ResponseEntity.ok(userService.deleteDeliveryBoy(userId));
	}

	@PostMapping("/category")
	public ResponseEntity<?> addNewCategory(@RequestBody Category category) {
		System.out.println(" in add new category method of controller " + category);
		return new ResponseEntity<>(catService.addNewCategory(category), HttpStatus.CREATED);
	}

	@GetMapping("/categoryList")
	public ResponseEntity<?> CategoryList() {
		System.out.println(" in add new category method of controller ");
		return new ResponseEntity<>(catService.categoryList(), HttpStatus.CREATED);
	}

	@GetMapping("/orderDetails")
	public ResponseEntity<?> getAllOrders() {
		System.out.println("in get all user order details");
		return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
	}

	@GetMapping("/userList")
	public ResponseEntity<?> findAllUser() {
		System.out.println("in find all method cntr");
		return new ResponseEntity<>(userService.userList(), HttpStatus.OK);
	}

	@GetMapping("/restList")
	public ResponseEntity<?> findAllRestaurant() {
		System.out.println("in find all method cntr");
		return new ResponseEntity<>(restService.restList(), HttpStatus.OK);
	}

	@GetMapping("/userCount")
	public ResponseEntity<?> finduserCount() {
		System.out.println("in find all method cntr");
		return new ResponseEntity<>(userService.usercount(), HttpStatus.OK);
	}

	@GetMapping("/orderCount")
	public ResponseEntity<?> findorderCount() {
		System.out.println("in find all method cntr");
		return new ResponseEntity<>(orderService.ordercount(), HttpStatus.OK);
	}

	@GetMapping("/restCount")
	public ResponseEntity<?> findrestCount() {
		System.out.println("in find all method cntr");
		return new ResponseEntity<>(restService.restcount(), HttpStatus.OK);
	}

	@GetMapping("/totalsales")
	public ResponseEntity<?> findtotalsales() {
		return new ResponseEntity<>(payService.totalsales(), HttpStatus.OK);
	}

}
