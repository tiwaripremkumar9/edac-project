package com.app.dtos;

public class UpdateFoodDTO {
	
	private String name;
	private double price;
	private String description;
	private String foodStatus;
	
	public UpdateFoodDTO() {
		System.out.println(" in ctor of "+getClass().getName());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}

	
	
	

}
