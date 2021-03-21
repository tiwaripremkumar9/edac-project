package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address")
public class Address extends BaseEntity{
		
	@NotEmpty
	private String userAddress;
	
	@Column(length = 10)
	private String pin;
	
	@JsonIgnoreProperties({"email", "mobile", "password", "role"})
	@JoinColumn(name="user_id", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private User userId;
	
	
	public Address() {
		System.out.println("in constructor of: "+getClass().getName());
	}

	public Address(String userAddress, String pincode, User userId) {
		super();
		this.userAddress = userAddress;
		this.pin = pincode;
		this.userId = userId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPincode() {
		return pin;
	}

	public void setPincode(String pincode) {
		this.pin = pincode;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Address [userAddress=" + userAddress + ", pin=" + pin + ", userId=" + userId + ",Id=" + getId()
				+ "]";
	}

	
	

	
	
}
