package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	@Query("select r from Restaurant r where r.name LIKE %?1%")
	List<Restaurant> findByName(@RequestParam("name") String name);

	List<Restaurant> findByPincode(String pincode);

	Restaurant findById(int id);

	Restaurant findByEmailAndPassword(String email, String password);
}
