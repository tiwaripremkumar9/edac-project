package com.app.dtos;

public class RestDTO {
	private int id;
	private String mob;
	private String name;
	private String password;
	private String pincode;
	
	public RestDTO() {
		System.out.println("in ctor of RestDTO");
	}

	public RestDTO(int id, String mob, String name, String password, String pincode) {
		super();
		this.id = id;
		this.mob = mob;
		this.name = name;
		this.password = password;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "RestDTO [id=" + id + ", mob=" + mob + ", name=" + name + ", password=" + password + ", pincode="
				+ pincode + "]";
	}
	
}
