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

/**
 * =====================
 * Auto ID Generator
 * =====================
 */
public class IdGenerator {
	private static int employeeIdCounter = 1000;
	private static int assignmentIdCounter = 2000;
	
	public static synchronized int generateEmployeeId() {
		return employeeIdCounter++;
	}
	
	public static synchronized int generateAssignmentId() {
		return assignmentIdCounter++;
	}
}
