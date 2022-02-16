package com.ecommerce.app.service;

import java.util.List;

import com.ecommerce.app.entity.Order;

public interface OrderService {

	void createOrder();

	List<Order> getOrders();

}
