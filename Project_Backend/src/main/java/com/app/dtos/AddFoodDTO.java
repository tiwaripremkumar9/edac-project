package com.app.dtos;

public class AddFoodDTO {
	
	private String name;
	private double price;
	private String description;
	private boolean inactiveStatus;
	private String category;
	
	public AddFoodDTO() {
		System.out.println(" in ctor of "+getClass().getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInactiveStatus() {
		return inactiveStatus;
	}

	public void setInactiveStatus(boolean inactiveStatus) {
		this.inactiveStatus = inactiveStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	

}
