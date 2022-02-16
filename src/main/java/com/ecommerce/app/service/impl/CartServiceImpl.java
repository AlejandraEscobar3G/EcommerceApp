package com.ecommerce.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.dto.CartProduct;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.CartService;
import com.ecommerce.app.service.ProductService;
import com.ecommerce.app.service.UserService;

@Service
public class CartServiceImpl implements CartService {

	static int count = 0;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Override
	public void addCartItem(Product product) {
		if(cartDao.getCartList().containsKey(product.getProductId())) {
			double quantity = cartDao.getCartList().get(product.getProductId()).getQuantity();
			cartDao
			.getCartList()
			.get(product.getProductId())
			.setQuantity(quantity + 1);
		} else {
			Cart cart = new Cart();
			cart.setQuantity(1);
			cart.setCartId(count++);
			cart.setProductId(product.getProductId());
			cart.setUserId(userService.getUser().getUserId());
			cartDao.addCartItem(cart);
		}
	}

	@Override
	public List<CartProduct> getCartList() {
		List<Cart> cartList = new ArrayList<Cart>(cartDao.getCartList().values());
		List<CartProduct> cartProductList = new ArrayList<CartProduct>();
		for(int i=0; i < cartList.size(); i++) {
			Integer productId = cartList.get(i).getProductId();
			Product product = productService.getProductsList()
					.stream()
					.filter(item -> productId == item.getProductId())
					.findAny().orElse(null);
			
			CartProduct cartProduct = new CartProduct();
			cartProduct.setProductName(product.getProductName());
			cartProduct.setProductCategory(product.getProductCategory());
			cartProduct.setProductPrice(product.getProductPrice());
			cartProduct.setProductQuantity(cartList.get(i).getQuantity());
			cartProduct.setProductSubtotal(cartProduct.getProductPrice() * cartProduct.getProductQuantity());
			cartProductList.add(cartProduct);
		}
		return cartProductList;
	}

	@Override
	public double getTotalCart(List<CartProduct> cartProduct) {
		double total = 0;
		for(int i=0; i<cartProduct.size(); i++) {
			total = total + cartProduct.get(i).getProductSubtotal();
		}
		return total;
	}
	
}
