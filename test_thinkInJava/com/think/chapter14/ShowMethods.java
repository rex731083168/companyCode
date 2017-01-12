package com.think.chapter14;

import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage show all methods";
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args) {
		if(args.length<1){
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			//Class<?> c 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
