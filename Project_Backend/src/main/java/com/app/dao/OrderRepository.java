package com.app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Order;
import com.app.pojos.Restaurant;
import com.app.pojos.User;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByRestaurantId(Restaurant restId);
	
	List<Order> findByUserId(User userId);

	@Query("select o from Order o where o.userId = :restId and o.status = 'PLACED' or o.status ='CANCELLED'")
	List<Order> getAllOrderToRestVendor(@Param("restId") Restaurant restId);
	
	@Query("select o from Order o where o.userId = :userid and o.id = :orderId and o.status = 'PLACED' or o.status ='DELIVERED'") 
	List<Order> getAllOrderToDelBoy(@Param("userid") User userid);
	
	@Modifying
	@Query(value="insert into orders (status,total_bill,user_id,rest_id,pay_id_id,order_Date) values ('PLACED',:totalBill,:userId,:restId,:payId, :orderTime)", nativeQuery = true)
	int insertOrder(double totalBill,int userId, int restId,int payId ,LocalDateTime orderTime);
}
