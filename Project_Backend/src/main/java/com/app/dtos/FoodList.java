package com.app.dtos;
import java.util.List;

import com.app.pojos.Foods;

public class FoodList {
private List<Foods> foodList;
public FoodList() {
	// TODO Auto-generated constructor stub
}
public FoodList(List<Foods> foodList) {
	super();
	this.foodList = foodList;
}
public List<Foods> getFoodList() {
	return foodList;
}
public void setFoodList(List<Foods> foodList) {
	this.foodList = foodList;
}
@Override
public String toString() {
	return "FoodList [foodList=" + foodList + "]";
}
}
