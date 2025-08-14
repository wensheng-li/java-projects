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

	/**
	 * Get the assignment ID
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the project name
	 * @return project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Get the start date of the assignment
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Get the end date of the assignment
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Set the assignment ID
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set the assignment name
	 * @param project
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Set the Start Date of the assignment
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Set the End Date of the assignment
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
