/**
 * Employee Dispatch Management System
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.itech.dispatch.employee;

/**
 * ============================================
 * Interface of Assignment Notification Service
 * ============================================
 */
public interface AssignmentNotificationService {
	void notifyAssignmentCreated(Assignment assignment);
	void notifyStatusChange(Employee employee, AssignmentStatus oldStatus,
			AssignmentStatus newStatus, String reason);
	void notifyAllAssignmentsCompleted(Employee employee);
}
