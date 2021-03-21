package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;

@Repository
public class AddressDaoImpl implements IAddressDao {
	
	@Autowired
	private EntityManager mgr;
	
	public AddressDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(" inside ctor of "+getClass().getName());
	}

	@Override
	public String getPincode(int id) {
		System.out.println(" inside get pincode method of address dao  "+id);
		String jpql = "select a from Address a where a.userId = :id";
		System.out.println(mgr.createQuery(jpql, Address.class).setParameter("id", id).getSingleResult());
		Address address = mgr.createQuery(jpql, Address.class).setParameter("id", id).getSingleResult();
		System.out.println(" address is  "+address);
		return address.getPincode();
	}

}
