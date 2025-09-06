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
import java.util.Date;

import com.itech.dispatch.auth.AuthManager;
import com.itech.dispatch.auth.User;
import com.itech.dispatch.ui.MainGUI;
import com.itech.dispatch.util.PasswordUtils;

// LoginPanel.java
public class LoginPanel extends JPanel {
	// Filter
	private final AuthManager authManager;
	private final MainGUI mainGUI;

	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lockoutLabel;
	private JButton unlockButton;

	// Track the lockout status
	private User lockedUser;

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

		// Locked Status label
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		lockoutLabel = new JLabel("", SwingConstants.CENTER);
		lockoutLabel.setForeground(Color.RED);
		lockoutLabel.setVisible(false);
		add(lockoutLabel, gbc);

		// Unlock button
		gbc.gridy = 5;
		unlockButton = new JButton("Unlock the Account");
		unlockButton.setVisible(false);
		unlockButton.addActionListener(e -> unlockAccount());
		add(unlockButton, gbc);
	}

	// Execute login event
	private void performLogin(ActionEvent e) {
		String username = usernameField.getText();
		char[] passwordChars = passwordField.getPassword();

		String password = PasswordUtils.getAndClearPassword(passwordChars);

		// Clear the password characters
		passwordField.setText("");
		try {
			User user = authManager.authenticate(username, password.toCharArray());
			if (user != null) {
				// Check if the password expired
				if (user.isPasswordExpired()) {
					showPasswordExpiryDialog(user);
				} else {
					mainGUI.loginSuccess(user);
				}
			} else {
				handleFailedLogin(username);
			}
		} finally {
			// Ensure the password has been cleared
			password = null;
		}
	}

	private void handleFailedLogin(String username) {
		// Get the user by username
		User user = authManager.getUser(username);
		StringBuilder failedAttemptMsg = new StringBuilder();
		StringBuilder errorMsg = new StringBuilder();

		if (user != null) {
			// Display the locked status of account
			if (user.isLockOut()) {
				lockedUser = user;
				showLockoutStatus(user);
			} else {
				int attemptsLeft = PasswordUtils.MAX_ATTEMPTS - user.getFailedAttempts();
				failedAttemptMsg.append("Username or password is incorrect, the attempts left ")
				.append(attemptsLeft);
				JOptionPane.showMessageDialog(this, 
						failedAttemptMsg, "Login failed", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			errorMsg.append("Username ").append(username).append(" or password is incorrect");
			JOptionPane.showMessageDialog(this, 
					errorMsg.toString(), "Login failed", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void showLockoutStatus(User user) {
		long lockoutTime = user.getLockoutUtil().getTime() - new Date().getTime();
		long minutes = lockoutTime / (60 * 1000);
		long seconds = (lockoutTime % (60 * 1000)) / 1000;
		String message = String.format("The account has been locked! Time left: %dmin%dsec", minutes, seconds);

		lockoutLabel.setText(message);
		lockoutLabel.setVisible(true);
		unlockButton.setVisible(true);
	}

	private void unlockAccount() {
		if (lockedUser != null) {
			// Administrator permission required
			StringBuilder confirmMsg = new StringBuilder();
			String msg = confirmMsg.append("Are sure you want to unlock the account for ")
					.append(lockedUser.getUsername())
					.append("?")
					.toString();
			int choice = JOptionPane.showConfirmDialog(
					this, msg, "Unlock Account", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if (choice == JOptionPane.YES_OPTION) {
				lockedUser.resetFailedAttempts();
				lockoutLabel.setVisible(false);
				unlockButton.setVisible(false);
				lockedUser = null;
				
				JOptionPane.showMessageDialog(
						this, "Account has been unlocked", 
						"Unlock successfully", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	private void showPasswordExpiryDialog(User user) {
		int daysLeft = (int) ((user.getPasswordExpiry().getTime() - new Date().getTime()) / (1000 * 60 * 60 *24));
		
		if (daysLeft <= 0) {
			// Force to change the password
			if(showPasswordChangeDialog(user, true)) {
				mainGUI.loginSuccess(user);
			}
		} else {
			// Warning that the expired date is closing
			int option = JOptionPane.showConfirmDialog(
					this, 
					"Your password will be expired in " + daysLeft + " days. Do you want to change it now?", 
					"Password is near expired", 
					JOptionPane.YES_NO_OPTION);
			
			if (option == JOptionPane.YES_OPTION) {
				showPasswordChangeDialog(user, true);
			}
			mainGUI.loginSuccess(user);
		}
	}
	
	private boolean showPasswordChangeDialog(User user, boolean mandatory) {
		// Show the change password dialog
		// return true if the password changed successfully
		return PasswordChangeDialog.showDialog(this, user, mandatory);
	}
}
