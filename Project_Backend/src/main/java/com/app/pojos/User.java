package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "users")
@Proxy(lazy = false)
public class User extends BaseEntity {

	@Column(length = 20)
	@NotEmpty
	private String email;

	@NotEmpty
	@Column(length = 20)
	private String name;

	@Column(length = 20, nullable = false)
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;

	@NotEmpty
	@Column(length = 15)
	private String mobile;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
		System.out.println(" in user ctor " + getClass().getName());
	}

	public User(String email, String name, String password, String mobile, Role role, Delivery deliveries) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.role = role;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", mobile=" + mobile + ", role=" + role + ", Id =" + getId()
				+ "]";
	}

}
