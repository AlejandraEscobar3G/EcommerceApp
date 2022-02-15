package com.ecommerce.app.service;

import java.util.List;

import com.ecommerce.app.entity.Cart;

public interface CartService {
	
	void addCartItem(Cart cart);
	List<Cart> getCartList();
}
