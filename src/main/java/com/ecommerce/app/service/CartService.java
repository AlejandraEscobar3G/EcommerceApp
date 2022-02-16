package com.ecommerce.app.service;

import java.util.List;

import com.ecommerce.app.dto.CartProduct;
import com.ecommerce.app.entity.Product;

public interface CartService {
	
	void addCartItem(Product product);
	List<CartProduct> getCartList();
	double getTotalCart(List<CartProduct> cartProduct);
}
