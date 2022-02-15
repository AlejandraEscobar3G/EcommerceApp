package com.ecommerce.app.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.entity.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	static Map<Integer, Cart> cartDatabase = new HashMap<Integer, Cart>();

	@Override
	public void addCartItem(Cart cart) {
		cartDatabase.put(cart.getProductId(), cart);
	}

	@Override
	public Map<Integer, Cart> getCartList() {
		return cartDatabase;
	}

}
