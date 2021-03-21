package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Foods;
import com.app.pojos.Restaurant;

public interface FoodRepository extends JpaRepository<Foods, Integer> {
	@Query("select f from Foods f where f.name LIKE %?1%")
	List<Foods> findByName(@RequestParam("name") String name);

	@Query("select f from Foods f where f.id = :foodId and f.restId.id = :restId ")
	Foods findByRestIdAndId(@Param("foodId") int foodId, @Param("restId") int restId);

	@Query("select f from Foods f where f.Category in (select c.id from Category c where c.catName Like ?1%)")
	List<Foods> findByCategory(@RequestParam("name") String category);

	Optional<Foods> findById(int id);

	@Query("select f from Foods f where f.restId = :restid")
	List<Foods> findByRestId(@Param("restid") Restaurant restid);

}
