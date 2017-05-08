package com.bruce.javaArithmetic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    Date effectDate = sf.parse("2017-05-05");
	    Calendar effect = Calendar.getInstance();
	    effect.setTime(effectDate);
	    effect.add(Calendar.DATE, 15);
	    //生效日15天后
	    String afterEffectStart = sf.format(effect.getTime());
	    System.out.println(afterEffectStart);
	    effect.add(Calendar.YEAR, 1);
	    //生效日15天后的周年
	    String afterEffectEnd = sf.format(effect.getTime());
	    System.out.println(afterEffectEnd);
	}
}
