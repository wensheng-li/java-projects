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

import java.util.Date;

/**
 * ==========================================
 * Implementation of AssignmentNotificationService
 * ==========================================
 */
public class LoggingNotificationService implements AssignmentNotificationService {

	@Override
	public void notifyAssignmentCreated(Assignment assignment) {
		System.out.printf("[%s] New Dispatch Assignment Created: %s (ID: %d)%n",
				new Date(), assignment.getProject(), assignment.getId());
	}

	@Override
	public void notifyStatusChange(Employee employee, AssignmentStatus oldStatus, AssignmentStatus newStatus,
			String reason) {
		System.out.printf("[%s] Employee Status Updates: %s (%s -> %s) Reasons: %s%n",
				new Date(), employee.getName(), oldStatus, newStatus, reason);
	}

	@Override
	public void notifyAllAssignmentCompleted(Employee employee) {
		System.out.printf("[%s] All Assignment Completed: %s all the assigned assignments has been completed%n",
				new Date(), employee.getName());
	}

}
