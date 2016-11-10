package com.Demo.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxSimple {
    public static void main(String[] args) {
		String patten = ".*Q[^U]\\d+\\..*";
		String line = "Order QT300. Now!";
		Pattern p = Pattern.compile(patten);
		Matcher matcher = p.matcher(line);
		if(matcher.find()){
			System.out.println(line+"matches\""+patten+"\"");
			System.out.println(matcher.start(0)+":"+matcher.end(0));
		}else {
			System.out.println("NO MATCH");
		}
		Matcher m = Pattern.compile("(.*),(.*)").matcher("Luo,Bruce");
		if(m.matches()){
			System.out.println(m.group(2)+" "+m.group(1));
		}
		String p1 = ".*[d].*";
		String ss = "afeDfaf";
		Pattern pattern = Pattern.compile(p1, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		System.out.println(pattern.matches(p1, ss));
	}
}
