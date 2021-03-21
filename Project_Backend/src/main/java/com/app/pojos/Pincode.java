package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pincode")
public class Pincode extends BaseEntity {
	
	@Column(length = 10)	
	private String pincode;
	
	public Pincode() {
		System.out.println("in constructor of: "+getClass().getName());
	}

	public Pincode(String pincode) {
		super();
		this.pincode = pincode;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
