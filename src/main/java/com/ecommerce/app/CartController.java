package com.ecommerce.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.dto.CartProduct;
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
		cartService.addCartItem(product);
		
		return "redirect:/getProducts";
	}
	
	@RequestMapping(value="/viewCart/{userId}", method = RequestMethod.GET)
	public ModelAndView getCartList(@PathVariable Integer userId, ModelAndView modelAndView) {
		if(userId == userService.getUser().getUserId()) {
			List<CartProduct> cartList = cartService.getCartList();
			double total = cartService.getTotalCart(cartList);
			modelAndView.addObject("cartList", cartList);
			modelAndView.addObject("total", total);
			modelAndView.addObject("userId", userId);
			modelAndView.setViewName("cart");
		} else {
			modelAndView.setViewName("loginfailure");
		}
		return modelAndView;
	}
}
