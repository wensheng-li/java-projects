/**
 * Employee Dispatch Management System
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.itech.dispatch.util;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * Used for real-time password strength checks
 */
public abstract class DocumentAdapter implements DocumentListener {
	public void insertUpdate(DocumentEvent e) {
		update(e);
	}
	
	public void removeUpdate(DocumentEvent e) {
		update(e);
	}

	public void changedUpdate(DocumentEvent e) {
		update(e);
	}
	
	public abstract void update(DocumentEvent e);
}
