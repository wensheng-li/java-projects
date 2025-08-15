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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ===================
 * Utilities for Date
 * ===================
 */
public class DateUtils {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static String formatDate(Date date) {
		return date != null ? DATE_FORMAT.format(date) : "";
	}
	
	public static String formatDateTime(Date date) {
		return date != null ? DATE_TIME_FORMAT.format(date) : "";
	}
}
