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
import java.awt.*;
import java.awt.event.ActionEvent;

import com.itech.dispatch.auth.AuthManager;
import com.itech.dispatch.auth.User;
import com.itech.dispatch.ui.MainGUI;

// LoginPanel.java
public class LoginPanel extends JPanel {
	// Filter
	private final AuthManager authManager;
	private final MainGUI mainGUI;

	private JTextField usernameField;
	private JPasswordField passwordField;

	// Constructor LoginPanel
	public LoginPanel(AuthManager authManager, MainGUI mainGUI) {
		this.authManager = authManager;
		this.mainGUI = mainGUI;
		initUI();
	}

	private void initUI() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Title
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		JLabel titleLabel = new JLabel("Employee Dispatch Management System", SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		add(titleLabel, gbc);

		// User label
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Username:"), gbc);

		// Username entry field
		gbc.gridx = 1;
		usernameField = new JTextField(20);
		add(usernameField, gbc);

		// Password label
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Password:"), gbc);

		// Password entry field
		gbc.gridx = 1;
		passwordField = new JPasswordField(20);
		add(passwordField, gbc);

		// Login buttons
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(this::performLogin);
		add(loginButton, gbc);
	}

	// Execute login event
	private void performLogin(ActionEvent e) {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());

		User user = authManager.authenticate(username, password);
		if (user != null) {
			mainGUI.loginSuccess(user);
		} else {
			JOptionPane.showMessageDialog(this, "username or password is incorrect", "Login failed",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
