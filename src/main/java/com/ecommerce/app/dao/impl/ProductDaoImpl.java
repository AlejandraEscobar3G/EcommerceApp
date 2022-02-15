package com.ecommerce.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.app.dao.ProductDao;
import com.ecommerce.app.entity.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
	List<Product> productList = new ArrayList<>();

	@Override
	public List<Product> getProducts() {
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Samsung Galaxy");
		product1.setProductCategory("Smartphone");
		product1.setProductPrice(25000);
		product1.setProductQuantity(100);
		
		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("Java web aplications");
		product2.setProductCategory("Book");
		product2.setProductPrice(1250);
		product2.setProductQuantity(4);
		
		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName("Boost active");
		product3.setProductCategory("Soda");
		product3.setProductPrice(35);
		product3.setProductQuantity(250);
		
		Product product4 = new Product();
		product4.setProductId(4);
		product4.setProductName("Ketchup");
		product4.setProductCategory("Food");
		product4.setProductPrice(25);
		product4.setProductQuantity(300);
		
		Product product5 = new Product();
		product5.setProductId(5);
		product5.setProductName("Iphone 13");
		product5.setProductCategory("Smartphone");
		product5.setProductPrice(35999);
		product5.setProductQuantity(150);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		
		return productList;
	}
}
