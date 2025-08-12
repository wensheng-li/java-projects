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

// Employe.java
public class Employee {
	private int id;
	private String name;
	private String department;
	private AssignmentStatus status;
	
	/**
	 * Constructor Employee
	 * 
	 * @param id
	 * @param name
	 * @param department
	 */
	public Employee(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.status = AssignmentStatus.PENDING;
	}

	// Getter & Setters
	/**
	 * Get employee ID
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get employee Name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get employee department
	 * 
	 * @return department
	 */
	public String getdepartment() {
		return department;
	}

	/**
	 * Get employee dispatch status
	 * 
	 * @return status
	 */
	public AssignmentStatus getStatus() {
		return status;
	}

	/**
	 * Set the employee ID
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set the employee name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the employee department
	 * 
	 * @param department セットする department
	 */
	public void setdepartment(String department) {
		this.department = department;
	}

	/**
	 * Set the employee dispatch status
	 * 
	 * @param status
	 */
	public void setStatus(AssignmentStatus status) {
		this.status = status;
	}
}
