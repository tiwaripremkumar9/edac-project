package com.app.dtos;

public class UserDTO {
	private int id;	
	private String mobile;
	private String name;
	private String password;	
	
	public UserDTO() {
		System.out.println("inside ctor of UserDTO");
	}

	public UserDTO(int id, String mobile, String name, String password) {
		super();
		this.id = id;		
		this.mobile = mobile;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	@Override
	public String toString() {
		return "UserDTO [id=" + id +" mobile=" + mobile + ", name=" + name + "]";
	}
	
}
