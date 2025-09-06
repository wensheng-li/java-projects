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

import com.itech.dispatch.util.PasswordUtils;

//AuthManager.java
public class AuthManager {
	private final Map<String, User> users = new HashMap<>();

	public AuthManager() {
		// Initial the test users - char[] password
		users.put("admin", createUser("admin", "Admin@1234", Role.ADMIN));
		users.put("manager", createUser("manager", "Manager@5678", Role.MANAGER));
		users.put("supervisor", createUser("supervisor", "Supervisor@9012", Role.SUPERVISOR));
		users.put("employee", createUser("employee", "Employee@3456", Role.EMPLOYEE));
	}
	
	// Create the user
	private User createUser(String username, String password, Role role) {
		return new User(username, password.toCharArray(), role);
	}
	
	// Authentication check
	public User authenticate(String username, char[] password) {
		User user = users.get(username);
		
		if (user == null) {
			return null; // The user is not existing
		}
		
		if (user.isLockOut()) {
			return null; // The user has been locked out
		}
		
		if (user.verifyPassword(password)) {
			return user;
		}
		
		return null;
	}
	
	// Add users (The feature of Administrator)
	public void addUser(String username, char[] password, Role role) {
		if (users.containsKey(username)) {
			throw new IllegalArgumentException("The username has been used.");
		}
		
		if (!PasswordUtils.isPasswordStrong(password)) {
			throw new IllegalArgumentException ("The password is not strong enough.");
		}
		
		users.put(username, new User(username, password, role));
	}
}
