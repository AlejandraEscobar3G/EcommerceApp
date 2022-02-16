package com.ecommerce.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.OrderDao;
import com.ecommerce.app.entity.Order;
import com.ecommerce.app.service.CartService;
import com.ecommerce.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	static int count = 0;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CartService cartService;
	
	@Override
	public void createOrder() {
		double total = cartService.getTotalCart(cartService.getCartList());
		Order order = new Order();
		order.setOrderId(count++);
		order.setTotal(total);
		order.setOrderDate(new Date());
		
		orderDao.createOrder(order);
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orderList = new ArrayList<Order>(orderDao.getOrderList().values());
		return orderList;
	}

}
