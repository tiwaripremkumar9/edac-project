package com.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrderRepository;
import com.app.pojos.Order;
import com.app.pojos.OrderStatus;
import com.app.pojos.Restaurant;
import com.app.pojos.User;

@Service
@Transactional
public class IOrderServiceImpl implements IOrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	Order order= new Order();
	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public List<Order> getAllOrdersToVendor(Restaurant restId) {
		System.out.println("in get order to vendor");
		List<Order> orderList = orderRepo.getAllOrderToRestVendor(restId);		
		System.out.println("list of orders: "+orderList);
		return orderList ;
	}

	@Override
	public List<Order> getAllOrdersToUser(User userId) {
		System.out.println("in get order to User");
		List<Order> orderList = orderRepo.findByUserId(userId);		
		System.out.println("list of orders: "+orderList);
		return orderList ;
	}

	@Override
	public List<Order> getAllOrdersToDeliveryBoy(User deliveryBoyId) {
		System.out.println("in get order to vendor");
		List<Order> orderList = orderRepo.getAllOrderToDelBoy(deliveryBoyId);		
		System.out.println("list of orders: "+orderList);
		return orderList ;
	}

	@Override
	public int insertOrder(double totalBill, int userId, int restId, int payId, LocalDateTime orderTime ) {
		return orderRepo.insertOrder(totalBill, userId, restId,payId,orderTime);
	}

	@Override
	public int ordercount() {
		return (int) orderRepo.count();
	}
	

}
