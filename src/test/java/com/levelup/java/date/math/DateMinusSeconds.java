package com.levelup.java.date.math;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * This java example will demonstrate subtracting seconds from date
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/subtract-seconds-from-date/'>Subtract seconds from date</a>
 * 
 */
public class DateMinusSeconds {

	private static final Logger logger = Logger.getLogger(DateMinusSeconds.class);

	@Test
	public void subtract_seconds_from_date_in_java () {
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.set(2013, 0, 1, 0, 0, 0);
		
		Calendar newYearsEve = Calendar.getInstance();
		newYearsEve.setTimeInMillis(newYearsDay.getTimeInMillis());
		newYearsEve.add(Calendar.SECOND, -60);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsDay.getTime()));
		logger.info(dateFormatter.format(newYearsEve.getTime()));

		assertTrue(newYearsEve.before(newYearsDay));
		
	}
	
	@Test
	public void subtract_seconds_from_date_in_java_with_joda () {
		
		DateTime newYearsDay = new DateTime(2013, 1, 1, 0, 0, 0, 0);
		DateTime newYearsEve = newYearsDay.minusSeconds(60);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(newYearsDay.toString(fmt));
		logger.info(newYearsEve.toString(fmt));

		assertTrue(newYearsEve.isBefore(newYearsDay));
		
	}
	
	@Test
	public void subtract_seconds_from_date_in_java_apachecommons () {
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.set(2013, 0, 1, 0, 0, 0);
		
		Date newYearsEve = DateUtils.addSeconds(newYearsDay.getTime(), -58);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsDay.getTime()));
		logger.info(dateFormatter.format(newYearsEve));

		assertTrue(newYearsEve.before(newYearsDay.getTime()));

	}
	
}
