package com.ecommerce.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.app.service.OrderService;
import com.ecommerce.app.service.UserService;

@Controller
public class PurchaseController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/purchase/{userId}", method = RequestMethod.GET)
	public String getCartList(@PathVariable Integer userId) {
		if(userId == userService.getUser().getUserId()) {
			orderService.createOrder();
		} else {
			return "redirect:/saveUser";
		}
		return "redirect:/orders/" + userId;
	}
}
