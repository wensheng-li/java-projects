/**
 * Employee Dispatch Management System
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.itech.dispatch.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 * ============= PasswordUtils ============= The utility class that contains the
 * strategies of password management.
 * 
 */
public class PasswordUtils {
	// Password strategy configuration
	public static final int MIN_LENGTH = 8;
	public static final int MAX_LENGTH = 20;
	public static final int MAX_ATTEMPTS = 5;
	public static final long LOCKOUT_DURATION = 30 * 60 * 1000; // 30 minutes
	public static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?";

	/**
	 * Check the password strength
	 * 
	 * @param password
	 * @return hasUpper,hasLower,hasDigit,hasSpecial
	 */
	public static boolean isPasswordStrong(char[] password) {
		if (password == null || password.length < MIN_LENGTH || password.length > MAX_LENGTH) {
			return false;
		}
		
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasDigit = false;
		boolean hasSpecial = false;
		
		for (char c : password) {
			if (Character.isUpperCase(c)) hasUpper = true;
			else if (Character.isLowerCase(c)) hasLower = true;
			else if (Character.isDigit(c)) hasDigit = true;
			else if (SPECIAL_CHARS.indexOf(c) >= 0) hasSpecial = true;
		}
		
		return hasUpper && hasLower && hasDigit && hasSpecial;
	}

	/**
	 * Get the password securely & clear the password after validation
	 * 
	 * @param passwordChars
	 * @return password
	 */
	public static String getAndClearPassword(char[] passwordChars) {
		if (passwordChars == null)
			return "";

		String password = new String(passwordChars).trim();
		clearPassword(passwordChars);
		return password;
	}

	/**
	 * Clear the password data
	 * 
	 * @param passwordChars
	 */
	public static void clearPassword(char[] passwordChars) {
		if (passwordChars != null) {
			Arrays.fill(passwordChars, (char) 0);
		}
	}

	/**
	 * Generate salt value
	 * 
	 * @return salt
	 */
	public static byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}
	
	// Hash processing for password
	public static String hashPassword(char[] password, byte[] salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);
			
			// Convert char[] to byte[]
			byte[] passwordBytes = new String(password).getBytes();
			byte[] hashedPassword = md.digest(passwordBytes);
			
			// Clear the sensitive data
			Arrays.fill(passwordBytes, (byte) 0);
			
			return Base64.getEncoder().encodeToString(hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Hashing algorithm not available", e);
		}
	}

	// Verify the password
	public static boolean verifyPassword(char[] inputPassword, byte[] salt, String storedHash) {
		String inputHash = hashPassword(inputPassword, salt);
		return inputHash.equals(storedHash);
	}
}
