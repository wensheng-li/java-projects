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

import java.util.Calendar;
import java.util.Date;

import com.itech.dispatch.util.PasswordUtils;

public class User {
	private String username;
//	private String password;
	private String passwordHash; // Store the hashed password
	private byte[] salt; // The salt value of password
	private Role role;
	private Date passwordExpiry; // The expire date for the password
	private int failedAttempts; // Attempts times
	private Date lockoutUntil; // Lockout until

	/**
	 * Constructor User
	 * 
	 * @param username
	 * @param password
	 * @param role
	 */
	public User(String username, char[] password, Role role) {
		this.username = username;
//		this.password = password;
		this.salt = PasswordUtils.generateSalt();
		this.passwordHash = PasswordUtils.hashPassword(password, salt);
		PasswordUtils.clearPassword(password);
		this.role = role;
		this.passwordExpiry = calculatePasswordExpiry();
		this.failedAttempts = 0;
		this.lockoutUntil = null;
	}

	// Calculate the expire date of the password (after 90 days)
	private Date calculatePasswordExpiry() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 90);
		return cal.getTime();
	}

	// Verify the password
	public boolean verifyPassword(char[] password) {
		// Check if the account is locked
		if (isLockOut()) {
			return false;
		}

		boolean valid = PasswordUtils.verifyPassword(password, salt, passwordHash);

		if (valid) {
			resetFailedAttempts();
			return true;
		} else {
			recordFailedAttempts();
			return false;
		}
	}

	// Check if the account is locked
	public boolean isLockOut() {

		return lockoutUntil != null && new Date().before(lockoutUntil);
	}

	// Record the times of failed attempts
	public void recordFailedAttempts() {
		failedAttempts++;

		if (failedAttempts >= PasswordUtils.MAX_ATTEMPTS) {
			lockAccount();
		}
	}

	// Lock the account
	private void lockAccount() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MILLISECOND, (int) PasswordUtils.LOCKOUT_DURATION);
		lockoutUntil = cal.getTime();
	}

	// Reset the failed attempts
	public void resetFailedAttempts() {
		failedAttempts = 0;
		lockoutUntil = null;
	}

	// Check the expire date of password
	public boolean isPasswordExpired() {
		return new Date().after(passwordExpiry);
	}

	// Change password
	public void changePassword(char[] oldPassword, char[] newPassword) {
		if (!verifyPassword(oldPassword)) {
			throw new SecurityException("The current password is incorrect!");
		}

		if (!PasswordUtils.isPasswordStrong(newPassword)) {
			throw new IllegalArgumentException("The new password is not meeting the strength requirements.");
		}
		
		this.salt = PasswordUtils.generateSalt();
		this.passwordHash = PasswordUtils.hashPassword(newPassword, salt);
		this.passwordExpiry = calculatePasswordExpiry();
		PasswordUtils.clearPassword(newPassword);
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
	 * Get the password expire date
	 * 
	 * @return password
	 */
	public Date getPasswordExpiry() {
		return passwordExpiry;
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
	 * Get the failed attempts number
	 * @return failedAttempts
	 */
	public int getFailedAttempts() {
		return failedAttempts;
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
	 * Set the password expire date
	 * 
	 * @param password
	 */
	public void setPassword(Date passwordExpiry) {
		this.passwordExpiry = passwordExpiry;
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
