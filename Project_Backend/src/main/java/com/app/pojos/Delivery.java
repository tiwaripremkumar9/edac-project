package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="deliveries")
public class Delivery extends BaseEntity {
	@Column(columnDefinition = "TINYINT")
	private boolean state;
	private int deliveryStatus;
	@OneToOne
	@JoinColumn(name="order_id")
	private Order orderId;
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address addressId;
	
	public Delivery() {
		// TODO Auto-generated constructor stub
	}

	public Delivery(boolean state, int deliveryStatus) {
		super();
		this.state = state;
		this.deliveryStatus = deliveryStatus;
		
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Delivery [state=" + state + ", deliveryStatus=" + deliveryStatus + ", getId()=" + getId() + "]";
	}

	
	
}
