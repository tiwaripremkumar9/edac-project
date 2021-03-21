package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	public CategoryServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(" in ctor of category service impl ");
	}
	
	public String addNewCategory(Category category) {
		System.out.println(" in add new category method of service "+category);
		String message = "new category added";
		if(category != null)
			catRepo.save(category);
		else
			message = "category addition failed";
		return message;
		
	}

	@Override
	public Category findByCatName(String catName) {
		System.out.println(" inside find by category name method of service "+catName);
		Category category = catRepo.findByCatName(catName);
		return category;
	}

	@Override
	public List<Category> categoryList() {
		return catRepo.findAll();
	}

}
