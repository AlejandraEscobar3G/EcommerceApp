package com.ecommerce.app.dao.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.UserDao;
import com.ecommerce.app.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	static HashMap<String, User> userDatabase = new HashMap<String, User>();
	static User currentUser;
	
	@Override
	public void saveUser(User user) {
		userDatabase.put(user.getName(), user);
	}

	@Override
	public User authenticateUser(String name, String password) {
		User user = userDatabase.get(name);
		
		if(user.getPassword().equals(password)) {
			currentUser = user;
			return user;
		}
		return null;
	}

	@Override
	public User getUser() {
		return currentUser;
	}
	
}
