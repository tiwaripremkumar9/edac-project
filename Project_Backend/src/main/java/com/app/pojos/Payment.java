package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {
	private static final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
	@OneToOne
	@JoinColumn(name = "rest_id")
	@JsonIgnoreProperties
	private Restaurant restId;
	@OneToOne
	@JsonIgnoreProperties
	@JoinColumn(name = "user_id")
	private User userId;

	@Column
	private LocalDateTime payTime;
	@Column(length = 20)
	private String payMethod;

	private double amount;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Restaurant restId, User userId, LocalDateTime payTime, String payMethod, double amount) {
		super();
		this.restId = restId;
		this.userId = userId;
		this.payTime = payTime;
		this.payMethod = payMethod;
		this.amount = amount;
	}

	public Restaurant getRestId() {
		return restId;
	}

	public void setRestId(Restaurant restId) {
		this.restId = restId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
