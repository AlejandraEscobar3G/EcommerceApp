package com.ecommerce.app.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.OrderDao;
import com.ecommerce.app.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	static Map<Integer, Order> orderDatabase = new HashMap<Integer, Order>();

	@Override
	public void createOrder(Order order) {
		orderDatabase.put(order.getOrderId(), order);
	}

	@Override
	public Map<Integer, Order> getOrderList() {
		return orderDatabase;
	}

}
