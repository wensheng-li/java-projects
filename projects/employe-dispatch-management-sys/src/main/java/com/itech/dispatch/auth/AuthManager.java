/**
 * Employee Dispatch Management System
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.itech.dispatch.auth;

import java.util.HashMap;
import java.util.Map;

//AuthManager.java
public class AuthManager {
	private final Map<String, User> users = new HashMap<>();

	public AuthManager() {
		// Initialising the test users
		users.put("admin", new User("admin", "admin123", Role.ADMIN));
		users.put("manager", new User("manager", "mgr123", Role.MANAGER));
		users.put("supervisor", new User("supervisor", "sup123", Role.SUPERVISOR));
		users.put("employee", new User("employee", "emp123", Role.EMPLOYEE));
	}

	public User authenticate(String username, String password) {
		User user = users.get(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
