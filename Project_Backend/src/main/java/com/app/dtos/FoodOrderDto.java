package com.app.dtos;

import java.util.List;

public class FoodOrderDto {
 private int userid;
 private int restid;
 private double totalPrice;
 private List<FoodCart> foodorder;
 
 public FoodOrderDto() {
	
}
public FoodOrderDto( int userid, int restid, double totalPrice) {
	super();
	this.userid = userid;
	this.restid = restid;
	this.totalPrice = totalPrice;
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

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public List<FoodCart> getFoodorder() {
	return foodorder;
}

public void setFoodorder(List<FoodCart> foodorder) {
	this.foodorder = foodorder;
}
@Override
public String toString() {
	return "FoodOrderDto [ userid=" + userid + ", restid=" + restid + ", totalPrice=" + totalPrice
			+ ", foodorder=" + foodorder + "]";
}
 
}
