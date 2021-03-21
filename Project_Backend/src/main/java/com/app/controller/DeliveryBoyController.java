package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IAddressService;

@RestController
@RequestMapping("/delivery_boy")
@CrossOrigin(origins = "http://localhost:3000")
public class DeliveryBoyController {
	
	@Autowired
	private IAddressService addressService;
	
	@GetMapping("/customer_list") 
	  public ResponseEntity<?> getAllCustomer(){
	  System.out.println("in get all customer"); 
	  return new ResponseEntity<>(addressService.getAllCustomer(),HttpStatus.OK);
	  }
}
