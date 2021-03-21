package com.app.dtos;

import java.util.List;

import com.app.pojos.Restaurant;

public class RestaurantsList {
private List<Restaurant> restList;

public RestaurantsList() {
	
}

@Override
public String toString() {
	return "RestaurantsList [restList=" + restList + "]";
}

public List<Restaurant> getRestList() {
	return restList;
}

public void setRestList(List<Restaurant> restList) {
	this.restList = restList;
}

public RestaurantsList(List<Restaurant> restList) {
	super();
	this.restList = restList;
}
}
