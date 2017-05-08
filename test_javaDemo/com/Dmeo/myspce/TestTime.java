package com.Dmeo.myspce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTime {
    public static void main(String[] args) throws ParseException {
    	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar tCalendar = Calendar.getInstance();
		Date tcrDate = sdf2.parse("2017-04-28");
		tCalendar.setTime(tcrDate);
	}
}
