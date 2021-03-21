package com.app.service;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.app.dtos.UserDTO;
import com.app.pojos.Foods;
import com.app.pojos.User;

public interface IUserService {
	User createNewUser(User user);
	User authenticateUser (String email, String password);
	User addNewDeliveryBoy(User deliveryBoy);
	String deleteDeliveryBoy(int deliveryBoyId);
	List<Foods> findByName(String Name);
	User updateUserDetails(int userId, UserDTO userDTO);
	String addAddress(int id, String address);
	
	@Query("select u.id ,u.name, u.email, u.mobile, u.role from User u ")
	List<User> userList();
	
	int usercount();
}
