package com.app.service;

import java.util.List;

import com.app.pojos.Category;

public interface ICategoryService {
	
	String addNewCategory(Category category);
	Category findByCatName(String catName);
	List<Category> categoryList();
	

}
