package com.app.dtos;

import java.time.LocalDateTime;

public class PaymentDto {
	private int userid;
	private int restid;
	private LocalDateTime payDate;
	private String payMethod;
	private double amount;

	public PaymentDto(int userid, int restid, LocalDateTime payDate, String payMethod, double amount) {
		super();
		this.userid = userid;
		this.restid = restid;
		this.payDate = payDate;
		this.payMethod = payMethod;
		this.amount = amount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRestid() {
		return restid;
	}

	public void setRestid(int restid) {
		this.restid = restid;
	}

	public LocalDateTime getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDateTime payDate) {
		this.payDate = payDate;
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
