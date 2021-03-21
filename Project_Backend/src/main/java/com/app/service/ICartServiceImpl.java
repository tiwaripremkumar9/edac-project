package com.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FoodRepository;
import com.app.dtos.FoodCart;
import com.app.pojos.Foods;

@Service
@Transactional
public class ICartServiceImpl implements ICartService {
	@Autowired
	private IFoodService foodService;

	private Map<Integer, Integer> foods = new HashMap<>();

	@Override
	public void addFood(int food) {
		System.out.println(foods.values());
		if (foods.containsKey(food)) {
			System.out.println(foods.get(food));
			foods.replace(food, foods.get(food) + 1);
		} else {
			System.out.println("in else");
			foods.put(food, 1);
		}

	}

	@Override
	public void removeProduct(int food) {
		System.out.println(food);
		if (foods.containsKey(food)) {
			if (foods.get(food) > 1)
				foods.replace(food, foods.get(food) - 1);
			else if (foods.get(food) == 1) {
				foods.remove(food);
			}
		}
	}

	@Override
	public List<FoodCart> getFoodInCart() {
		Foods food;
		List<FoodCart> foodcartList= new ArrayList<>();
		//Map<Foods, Integer> foodMap = new HashMap<Foods, Integer>();
		
		Iterator<Map.Entry<Integer, Integer>> entries = foods.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = entries.next();
			
			
			food=foodService.findById(entry.getKey()).get();
			foodcartList.add( new FoodCart(food.getId(),food.getName(),food.getPrice(),entry.getValue()));
			System.out.println(foodcartList);
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return foodcartList;
	}

}
