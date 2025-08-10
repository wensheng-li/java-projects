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

public class User {
	private String username;
	private String password;
	private Role role;
	
	/**
	 * Constructor User
	 * 
	 * @param username
	 * @param password
	 * @param role
	 */
	public User(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * Get the username
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get the password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Get the role
	 * 
	 * @return role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Set the user name
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Set the password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Set the role
	 * 
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
}
