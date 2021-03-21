package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.app.dao.FoodRepository;
import com.app.pojos.Foods;
import com.app.pojos.Restaurant;
@Service
@Transactional
public class IFoodServiceImpl implements IFoodService {
	@Autowired
	private FoodRepository foodRepo;
	@Override
	public Optional<Foods> findById(int id) {
		
		return foodRepo.findById(id);
	}

	@Override
	public String increaseFoodLikes(int id) {
		System.out.println(" in increase food likes "+id);
		String message = "Food likes increased ";
		Foods food = findById(id).get();
		int presentLikes = food.getLikes();
		food.setLikes(presentLikes + 1);
		if(food.getLikes() != presentLikes + 1)
			message = "food likes not increased";
		return message;
	}
	@Override
	public List<Foods> findByCategory(String category) {
		return foodRepo.findByCategory(category);
	}
	@Override
	public List<Foods> getAllFood(Restaurant restId) {		
		System.out.println("in get food to user");
		List<Foods> foodList = foodRepo.findByRestId(restId);		
		System.out.println("list of foods: "+foodList);
		return foodList;
	}

}
