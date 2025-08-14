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
import javax.swing.event.DocumentEvent;

import com.itech.dispatch.auth.User;
import com.itech.dispatch.util.DocumentAdapter;
import com.itech.dispatch.util.PasswordUtils;

import java.awt.*;
import java.util.Arrays;

public class PasswordChangeDialog extends JDialog {
	// Filters
	private final User user;
	private final boolean mandatory;
	private boolean passwordChanged = false;
	
	private JPasswordField currentPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JLabel strengthLabel;
	
	/**
	 * Constructor PasswordChangeDialog
	 * 
	 * @param parent
	 * @param user
	 * @param mandatory
	 */
	public PasswordChangeDialog(JFrame parent, User user, boolean mandatory) {
		super(parent, "Change password", true);
		this.user = user;
		this.mandatory = mandatory;
		initUI();
	}
	
	// Initialize the UI
	private void initUI () {
		setLayout(new GridLayout(0,2,10,10));
		
		add(new JLabel("Current password:"));
		currentPasswordField = new JPasswordField(20);
		add(currentPasswordField);
		
		add(new JLabel("New password:"));
		newPasswordField = new JPasswordField(20);
		newPasswordField.getDocument().addDocumentListener(new DocumentAdapter() {
			public void update(DocumentEvent e) {
				checkPasswordStrength();
			}
		});
		add(newPasswordField);
		
		add(new JLabel("Password strength:"));
		strengthLabel = new JLabel("");
		add(strengthLabel);
		
		add(new JLabel("Confirm new password: "));
		confirmPasswordField = new JPasswordField(20);
		add(confirmPasswordField);
		
		JButton okButton = new JButton("Confirmed");
		okButton.addActionListener(e -> changePassword());
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> {
			if (mandatory) {
				JOptionPane.showMessageDialog(this,
						"You must change the password to continue.",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				setVisible(false);
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		if(!mandatory) buttonPanel.add(cancelButton);
		
		add(new JLabel());
		add(buttonPanel);
		
		pack();
		setLocationRelativeTo(getParent());
	}
	
	// Check the strength of the password
	private void checkPasswordStrength() {
		char[] password = newPasswordField.getPassword();
		boolean isStrong = PasswordUtils.isPasswordStrong(password);
		PasswordUtils.clearPassword(password);
		
		if (isStrong) {
			strengthLabel.setText("Strength: Strong");
			strengthLabel.setForeground(Color.GREEN);
		} else {
			strengthLabel.setText(
					"Strength: weak - Please use uppercase,lowercase letters, digits and special character");
			strengthLabel.setForeground(Color.RED);
		}
	}
	
	// Change the password
	private void changePassword () {
		char[] currentPassword = currentPasswordField.getPassword();
		char[] newPassword = newPasswordField.getPassword();
		char[] confirmPassword = confirmPasswordField.getPassword();
		
		try {
			// Verify if the entered password match each other
			if (!Arrays.equals(newPassword, confirmPassword)) {
				JOptionPane.showMessageDialog(this,
						"New password is not matched",
						"Incorrect",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Change the password
			user.changePassword(currentPassword, newPassword);
			passwordChanged = true;
			JOptionPane.showMessageDialog(this,
					"Password changed successfully",
					"Succeffully",
					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, 
					e.getMessage(),
					"Password changes failed",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			PasswordUtils.clearPassword(currentPassword);
			PasswordUtils.clearPassword(newPassword);
			PasswordUtils.clearPassword(confirmPassword);
		}
	}
	
	public boolean isPasswordChanged () {
		return passwordChanged;
	}
	
	public static boolean showDialog(Component parent, User user, boolean mandatory) {
		Frame frame = JOptionPane.getFrameForComponent(parent);
		PasswordChangeDialog dialog = new PasswordChangeDialog((JFrame)frame, user, mandatory);
		dialog.setVisible(true);
		return dialog.isPasswordChanged();
	}
}
