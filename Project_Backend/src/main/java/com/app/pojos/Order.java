package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column(name="orderDate")
	private LocalDateTime orderDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime deliveryTime;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	private double totalBill;
	
	@JoinColumn
	@OneToOne
	private Payment payId;

	@JsonIgnoreProperties({ "email", "mobile", "password", "role" })
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;

	@JsonIgnoreProperties({ "email", "mob", "password", "pincode" })
	@ManyToOne
	@JoinColumn(name = "rest_id")
	private Restaurant restaurantId;

	public Order() {
		System.out.println("in constructor of: " + getClass().getName());
	}

	public Order(int quantity, LocalDateTime orderDate, LocalDateTime statusTime, OrderStatus status,
			double totalBill) {
		super();
		this.orderDate = orderDate;
		this.deliveryTime = statusTime;
		this.status = status;
		this.totalBill = totalBill;

	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getStatusTime() {
		return deliveryTime;
	}

	public void setStatusTime(LocalDateTime statusTime) {
		this.deliveryTime = statusTime;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "Order [ orderDate=" + orderDate + ", statusTime=" + deliveryTime + ", status="
				+ status + ", totalBill=" + totalBill + "]";
	}

}
