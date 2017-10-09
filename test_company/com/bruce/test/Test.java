package com.bruce.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
    	SimpleDateFormat sdfTime2 = new SimpleDateFormat("HHmmssSS");
    	System.out.println(sdfTime2.format(new Date()));
	}
}
