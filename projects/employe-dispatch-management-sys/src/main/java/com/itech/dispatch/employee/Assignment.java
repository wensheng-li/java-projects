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

import java.util.*;

// Assignment.java
public class Assignment {
	// Filters
	private final int id;
	private final String project;
	private final Date startDate;
	private final Date endDate;
	private Set<Employee> assignedEmployees = new HashSet<>();
	
	/**
	 * Constructor Assignment
	 * 
	 * @param id
	 * @param project
	 * @param startDate
	 * @param endDate
	 */
	public Assignment(int id, String project, Date startDate, Date endDate) {
		this.id = id;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	// Add employee to the assignedEmployee set
	public void addEmployee (Employee employee) {
		assignedEmployees.add(employee);
	}
	
	// Remove the employee
	public boolean removeEmployee(Employee employee) {
		return assignedEmployees.remove(employee);
	}
	
	// Getters
	public int getId() {
		return id;
	}

	public String getProject() {
		return project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Set<Employee> getAssignedEmployees() {
		return Collections.unmodifiableSet(assignedEmployees);
	}
	
	// Calculate the assignment progress
	public int calculateProgress () {
		Date now = new Date();
		if (now.before(startDate)) return 0;
		if(now.after(endDate)) return 100;
		
		long totalDuration = endDate.getTime() - startDate.getTime();
		long elapsed = now.getTime() - startDate.getTime();
		
		return (int) ((elapsed * 100) / totalDuration);
	}
	
	// Check if assignment completed
	public boolean isCompleted () {
		return new Date().after(endDate);
	}
	
	@Override
	public String toString() {
		return project + " (" + assignedEmployees.size() + " employees)";
	}
}
