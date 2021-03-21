package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.Restaurant;
import com.app.pojos.User;

public interface IOrderService {
	List<Order> getAllOrders();
	List<Order> getAllOrdersToVendor(Restaurant restId);
	List<Order> getAllOrdersToUser(User restId);
	List<Order> getAllOrdersToDeliveryBoy(User deliveryBoyId);
	int insertOrder(double totalBill, int userId, int restId,int payId, LocalDateTime orderTime);
	int ordercount();
	
	
}
