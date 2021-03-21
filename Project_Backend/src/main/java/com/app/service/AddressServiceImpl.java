package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressDaoImpl;
import com.app.dao.AddressRepository;
import com.app.pojos.Address;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressRepository addRepo;
	
	@Autowired
	private AddressDaoImpl addDao;
	
	public AddressServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(" in address service impl ");
	}

	
	  @Override public String getPincode(int id) {
		  System.out.println(" in get pincode method of address service "+id);
		  Address address = addRepo.findByUserId(id);
		  System.out.println("address is  "+address);
		  return address.getPincode();
	  }
	 
	  @Override public List<Address> getAllCustomer() {
		System.out.println("in get all customer to admin: "); 
		List<Address> userList = addRepo.getAllCustomerToAdmin();		  
		System.out.println("list of customer: "+userList); 
		return userList; 
	}
	
	
}
