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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Assignment.java
public class Assignment {
	// Filters
	private int id;
	private String project;
	private Date startDate;
	private Date endDate;
	private List<Employee> assignedEmployees = new ArrayList<>();
	
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
	
	// Getters & Setters
	/**
	 * Add employee to the assignedEmployee list
	 * 
	 * @param employee
	 */
	public void addEmployee (Employee employee) {
		assignedEmployees.add(employee);
	}
	
	/**
	 * Get assigned employee
	 * 
	 * @return assignedEmployees
	 */
	public List<Employee> getAssginedEmployees() {
		return assignedEmployees;
	}
}
