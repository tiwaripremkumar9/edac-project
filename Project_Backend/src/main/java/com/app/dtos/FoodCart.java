package com.app.dtos;

public class FoodCart {
private Integer id;
private String name;
private Double price;
private int quantity;

public FoodCart() {
	// TODO Auto-generated constructor stub
}

public FoodCart(int id, String name, Double price, int quantity) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "FoodList [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
}

}
