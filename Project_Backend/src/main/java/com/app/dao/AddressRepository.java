package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("select a from Address a where a.userId.id = :id ")
	Address findByUserId(@Param("id") int id);

	@Query("select add from Address add join fetch User u on u.id = add.userId.id where u.role='CUSTOMER'")
	List<Address> getAllCustomerToAdmin();
}
