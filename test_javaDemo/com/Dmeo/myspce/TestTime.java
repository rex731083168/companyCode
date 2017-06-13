package com.Dmeo.myspce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTime {
    public static void main(String[] args) throws ParseException {
    	long time = System.currentTimeMillis();
    	String timeStr = "1494225358864";
    	long timeS = new Long(timeStr);
    	System.out.println(timeS);
	}
}
