package com.ecommerce.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	static int count = 0;
	
	@Autowired
	CartDao cartDao;
	
	@Override
	public void addCartItem(Cart cart) {
		if(cartDao.getCartList().containsKey(cart.getProductId())) {
			double quantity = cartDao.getCartList().get(cart.getProductId()).getQuantity();
			cartDao
			.getCartList()
			.get(cart.getProductId())
			.setQuantity(quantity + 1);
		} else {
			cart.setQuantity(1);
			cart.setCartId(count++);
			cartDao.addCartItem(cart);
		}
		
	}

	@Override
	public List<Cart> getCartList() {
		List<Cart> cartList = new ArrayList<Cart>(cartDao.getCartList().values());
		return cartList;
	}
	
}
