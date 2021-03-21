package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity {
	@Column(length = 20)
	@NotEmpty
	private String name;
	@Column(length = 20, unique = true)
	@NotEmpty
	private String email;
	@Column(length = 20)
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;
	@Column(length = 15)
	@NotEmpty
	private String mob;

	@Column(length = 15)
	private String pincode;

	public Restaurant() {
		System.out.println("in ctr of " + getClass().getName());
	}

	public Restaurant(String name, String email, String password, String mob, String pincode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mob = mob;
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", email=" + email + ", password=" + password + ", mob=" + mob
				+ ", pincode=" + pincode + ", getId()=" + getId() + "]";
	}

}
