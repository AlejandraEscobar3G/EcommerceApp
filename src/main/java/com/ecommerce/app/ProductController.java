package com.ecommerce.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.ProductService;
import com.ecommerce.app.service.UserService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getProducts", method=RequestMethod.GET)
	public ModelAndView getAllProducts(ModelAndView modelAndView) {
		List<Product> productsList = productService.getProductsList();
		modelAndView.addObject("productsList", productsList);
		modelAndView.addObject("userId", userService.getUser().getUserId());
		modelAndView.setViewName("productsview");
		
		return modelAndView;
	}
}
