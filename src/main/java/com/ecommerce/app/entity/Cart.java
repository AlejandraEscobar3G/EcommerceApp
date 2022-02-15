package com.ecommerce.app.entity;

public class Cart extends Invoice {
	private Integer cartId;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}	
}
