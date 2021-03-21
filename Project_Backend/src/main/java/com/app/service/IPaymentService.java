package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Payment;


public interface IPaymentService {
	Payment addPayment(@RequestParam int userId,@RequestParam int orderId, Payment payId);
	
	int insertPayment(int restId, int userId,LocalDateTime payDate,double amount);
	
	int fetchPaymentId(int restId, int userId, LocalDateTime payDate);

	double totalsales();
}
