package com.ecommerce.app.entity;

public class Order extends Invoice {
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
