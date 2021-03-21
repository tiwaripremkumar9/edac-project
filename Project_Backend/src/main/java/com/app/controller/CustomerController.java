package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FoodOrderDto;
import com.app.dtos.PaymentDto;
import com.app.pojos.User;
import com.app.service.IAddressService;
import com.app.service.IOrderService;
import com.app.service.IPaymentService;
import com.app.service.IRestaurantService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private IRestaurantService restService;
	@Autowired
	private IAddressService addService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IPaymentService payService;

	public CustomerController() {

		System.out.println(" in ctor of " + getClass().getName());
	}

	@GetMapping("/{cust_id}/rest_list")
	public ResponseEntity<?> displayRestaurantLists(@PathVariable("cust_id") int id) {

		String pincode = addService.getPincode(id);
		System.out.println(" pincode  " + pincode);
		System.out.println(" in restaurant controller method of  " + pincode + " ");
		System.out
				.println(" restaurants for that particular customers are  " + restService.displayRestaurants(pincode));
		return new ResponseEntity<>(restService.displayRestaurants(pincode), HttpStatus.FOUND);

	}

	@GetMapping("/orderDetails/{userId}")
	public ResponseEntity<?> getAllOrdersToVendor(@PathVariable User userId) {
		System.out.println("in order details to Customer: " + userId);
		return new ResponseEntity<>(orderService.getAllOrdersToUser(userId), HttpStatus.OK);
	}

	@GetMapping("/restlist")
	public ResponseEntity<?> getAllRestaurant() {
		System.out.println("in get all restaurant list");
		return new ResponseEntity<>(restService.getAllRestaurant(), HttpStatus.OK);
	}

	@PostMapping("/totalBill")
	public ResponseEntity<?> getBillDetails(@RequestBody FoodOrderDto foodOrder) {
		System.out.println(foodOrder);
		System.out.println(foodOrder.getUserid());
		PaymentDto pay = new PaymentDto(foodOrder.getRestid(), foodOrder.getUserid(), LocalDateTime.now(), "WALLET",
				foodOrder.getTotalPrice());
		if (payService.insertPayment(pay.getRestid(), pay.getUserid(), pay.getPayDate(), pay.getAmount()) == 1) {
			int payId = payService.fetchPaymentId(pay.getRestid(), pay.getUserid(), pay.getPayDate());
			return new ResponseEntity<>(orderService.insertOrder(foodOrder.getTotalPrice(), foodOrder.getUserid(),
					foodOrder.getRestid(), payId, pay.getPayDate()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
