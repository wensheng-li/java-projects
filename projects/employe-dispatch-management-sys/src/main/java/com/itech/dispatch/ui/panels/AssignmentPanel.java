/**
 * Employee Dispatch Management System
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.itech.dispatch.ui.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.itech.dispatch.auth.Role;
import com.itech.dispatch.auth.User;
import com.itech.dispatch.employee.Assignment;
import com.itech.dispatch.employee.AssignmentManager;
import com.itech.dispatch.employee.Employee;

import java.awt.*;
import java.util.List;

public class AssignmentPanel extends JPanel {
	// Filter
	private final AssignmentManager assignmentManager;
	private final User currentUser;
	private JTable assignmentTable;

	/**
	 * Constructor AssignmentPanel
	 * 
	 * @param assignmentManager
	 * @param currentUser
	 */
	public AssignmentPanel(AssignmentManager assignmentManager, User currentUser) {
		this.assignmentManager = assignmentManager;
		this.currentUser = currentUser;
		initUI();
	}

	private void initUI() {
		setLayout(new BorderLayout());

		// Title
		JLabel titleLabel = new JLabel("My dispatch assignment", SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		add(titleLabel, BorderLayout.NORTH);

		// Assignment table
		String[] columnNames = { "ID", "Project Name", "Start Date", "End Date", "Status" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		List<Assignment> assignments = assignmentManager.getAssignmentForUser(currentUser);
		for (Assignment assignment : assignments) {
			for (Employee emp : assignment.getAssginedEmployees()) {
				// Display the assignments for current user
				if (emp.getName().contains(currentUser.getUsername())) {
					Object[] rowData = { 
							assignment.getId(), 
							assignment.getProject(), 
							assignment.getStartDate(),
							assignment.getEndDate(), 
							emp.getStatus().name()
					};
					model.addRow(rowData);
				}
			}
		}

		assignmentTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(assignmentTable);
		add(scrollPane, BorderLayout.CENTER);

		// Status updates Button (For the Supervisor or above users)
		if (currentUser.getRole() != Role.EMPLOYEE) {
			JButton updateButton = new JButton("Status Update");
			updateButton.addActionListener(e -> updateStatus());
			add(updateButton, BorderLayout.SOUTH);
		}
	}

	private void updateStatus() {
		int selectedRow = assignmentTable.getSelectedRow();
		if (selectedRow >= 0) {
			int assignmentId = (int) assignmentTable.getValueAt(selectedRow, 0);
			
			// Logics of updating status
			StringBuilder successMsg = new StringBuilder();
			successMsg.append("Update the status of assignment ").append(assignmentId);
			JOptionPane.showMessageDialog(this, successMsg.toString());
		} else {
			JOptionPane.showMessageDialog(this, "Please select an assignment", "Incorrect",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
