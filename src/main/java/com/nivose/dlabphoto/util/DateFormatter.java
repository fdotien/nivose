/**
 * 
 */
package com.nivose.dlabphoto.util;

import java.time.LocalDateTime;

/**
 * @author Dotien Joel
 *
 */

public class DateFormatter {

	public LocalDateTime dateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime currentTime = ldt.withNano(0);
		return currentTime;
	}

}

