package com.event.registration.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventUtility {

	public static Date convetToDate(String joinDate) throws ParseException {
		Date date = null;
		try {

			date = new SimpleDateFormat("dd/MM/yyyy").parse(joinDate);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

}
