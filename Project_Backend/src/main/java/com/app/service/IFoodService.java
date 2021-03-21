package com.app.service;

import java.util.Optional;
import java.util.List;
import com.app.pojos.Foods;
import com.app.pojos.Restaurant;

public interface IFoodService {
	Optional<Foods> findById(int id);
	String increaseFoodLikes(int id);
List<Foods> findByCategory(String category);
List<Foods> getAllFood(Restaurant restId);
}
