package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
	
	@Column(name = "cat_name", unique = true)
	private String catName;
	
	public Category() {
		System.out.println("in constructor of: "+getClass().getName());
	}

	public Category(String catName) {
		super();
		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "Category [catName=" + catName + ", Id=" + getId() + "]";
	}

	
}
