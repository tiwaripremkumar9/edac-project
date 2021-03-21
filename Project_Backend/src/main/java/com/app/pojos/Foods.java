package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "foods")
public class Foods extends BaseEntity {
	@Column(length = 50)
	@NotEmpty
	private String name;
	@Column
	@NotNull
	private double price;
	@Column
	@NotEmpty
	private String description;

	@OneToOne
	private Category Category;
	private int likes;

	@ManyToOne
	@JoinColumn(nullable = false, name = "rest_id")
	private Restaurant restId;
	
	@Column(name = "Inactive_status", columnDefinition = "TINYINT" )
	private boolean foodStatus;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order orderId;
	public Foods() {
		System.out.println("in ctr of " + getClass().getName());
	}

	
	public Foods( String name,  double price,  String description,
			 int likes, boolean foodStatus) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.likes = likes;
		this.foodStatus = foodStatus;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Restaurant getRestId() {
		return restId;
	}

	public void setRestId(Restaurant restId) {
		this.restId = restId;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public boolean isFoodStatus() {
		return foodStatus;
	}


	public void setFoodStatus(boolean foodStatus) {
		this.foodStatus = foodStatus;
	}


	@Override
	public String toString() {
		return "{name:" + name + ", price:" + price  + ", id:" + getId()
				+ "}";
	}


	

}
