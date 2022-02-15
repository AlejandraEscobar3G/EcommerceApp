package com.ecommerce.app.dao;

import java.util.Map;

import com.ecommerce.app.entity.Cart;

public interface CartDao {
	void addCartItem(Cart cart);
	Map<Integer, Cart> getCartList();
}
