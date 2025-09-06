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

import java.util.Objects;

// Employe.java
public class Employee {
	private int id;
	private String username;
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
	public Employee(int id, String username, String name, String department) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.department = department;
		this.status = AssignmentStatus.PENDING;
	}

	// Getters
	/**
	 * Get employee ID
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get employee Name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get employee department
	 * @return department
	 */
	public String getdepartment() {
		return department;
	}

	/**
	 * Get employee dispatch status
	 * @return status
	 */
	public AssignmentStatus getStatus() {
		return status;
	}

	/**
	 * Set the employee dispatch status
	 * 
	 * @param status
	 */
	public void setStatus(AssignmentStatus status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return id == employee.id;
	}
	
	@Override
	public int hashCode () {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return name + " (" + department + ")";
	}
}
