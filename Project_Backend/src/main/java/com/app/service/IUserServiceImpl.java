package com.app.service;

import com.app.dao.AddressRepository;
import com.app.dao.FoodRepository;

import com.app.dao.UserRepository;
import com.app.dtos.UserDTO;
import com.app.pojos.Address;
import com.app.pojos.Foods;
import com.app.pojos.User;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private FoodRepository foodRepo;
	@Autowired
	private AddressRepository addRepo;



	@Override
	public User createNewUser(User user) {
		System.out.println("in service of user: "+ user);
		System.out.println("user"+ user.getId());
		return userRepo.save(user);
	}
	@Override
	public User authenticateUser(String email, String password) {
		System.out.println(" user credentials  "+userRepo.findByEmailAndPassword(email, password));
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User addNewDeliveryBoy(User deliveryBoy) {
		System.out.println("in service of user: "+ deliveryBoy);
		System.out.println("delivery"+deliveryBoy.getId());
		return userRepo.save(deliveryBoy);
	}

	@Override
	public String deleteDeliveryBoy(int deliveryBoyId) {
		userRepo.deleteById(deliveryBoyId);
		return "Delivery Boy with Id "+deliveryBoyId+"deleted";
		
	}
	@Override
	public List<Foods> findByName(String Name) {
		return foodRepo.findByName(Name);
	}
	@Override
	public User updateUserDetails(int userId,@RequestParam UserDTO userDTO) {
		System.out.println("in update "+userDTO);		
		User userDetails=userRepo.findById(userId).get();
		//System.out.println("userId " +userDetails.getId());
		System.out.println("user dtls from db "+userDetails);		
		BeanUtils.copyProperties(userDTO, userDetails, "email");
		System.out.println("updated user dtls "+userDetails);		
		return userDetails;
	}

	@Override
	public String addAddress(int id, String newAddress) {
		String message = "Address accepted";
		System.out.println(" add address of user in service method  "+id+"  "+newAddress);
		Address address =	addRepo.findByUserId(id);
		if(newAddress != null && address != null)
			address.setUserAddress(newAddress);
		else
			message = "Invalid Address";
		return message;
	}
	@Override
	public List<User> userList() {
		return userRepo.findAll();
	}
	@Override
	public int usercount() {
		return (int) userRepo.count();
	}
	
}
