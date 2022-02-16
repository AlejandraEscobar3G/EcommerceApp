package com.ecommerce.app.dao;

import java.util.Map;

import com.ecommerce.app.entity.Order;

public interface OrderDao {

	void createOrder(Order order);
	Map<Integer, Order> getOrderList();
}
