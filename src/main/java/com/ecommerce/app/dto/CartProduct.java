package com.ecommerce.app.dto;

import com.ecommerce.app.entity.Item;

public class CartProduct extends Item {
	
	private Double productSubtotal;

	public Double getProductSubtotal() {
		return productSubtotal;
	}

	public void setProductSubtotal(Double productSubtotal) {
		this.productSubtotal = productSubtotal;
	}
}
