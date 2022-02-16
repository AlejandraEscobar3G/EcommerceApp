package com.ecommerce.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Order;
import com.ecommerce.app.service.OrderService;
import com.ecommerce.app.service.UserService;

@Controller
public class OrderController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;

	@RequestMapping(value="/orders/{userId}", method = RequestMethod.GET)
	public ModelAndView getOrders(@PathVariable Integer userId, ModelAndView modelAndView) {
		if(userId == userService.getUser().getUserId()) {
			List<Order> ordersList = orderService.getOrders();
			modelAndView.addObject("ordersList", ordersList);
			modelAndView.setViewName("orders");
		} else {
			modelAndView.setViewName("loginfailure");
		}
		return modelAndView;
	}
}
