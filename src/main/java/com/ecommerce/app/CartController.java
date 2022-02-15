package com.ecommerce.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.CartService;
import com.ecommerce.app.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute Product product) {
		System.out.println(product.getProductId());
		Cart cart = new Cart();
		cart.setProductId(product.getProductId());
		cart.setUserId(userService.getUser().getUserId());
		cartService.addCartItem(cart);
		
		return "redirect:/getProducts";
	}
	
	@RequestMapping(value="/viewCart/{userId}", method = RequestMethod.GET)
	public ModelAndView getCartList(@PathVariable Integer userId, ModelAndView modelAndView) {
		if(userId == userService.getUser().getUserId()) {
			List<Cart> cartList = cartService.getCartList();
			modelAndView.addObject("cartList", cartList);
			modelAndView.setViewName("cart");
		} else {			
			modelAndView.setViewName("loginfailure");
		}
		return modelAndView;
	}
}
