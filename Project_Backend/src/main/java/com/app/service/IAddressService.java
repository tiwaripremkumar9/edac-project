package com.app.service;

import java.util.List;

import com.app.pojos.Address;

public interface IAddressService {
	
	String getPincode(int id);
	List<Address> getAllCustomer();

}
