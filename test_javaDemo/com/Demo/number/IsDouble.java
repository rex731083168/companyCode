package com.Demo.number;

import java.util.regex.Pattern;

public class IsDouble {
	private static Number NAN = new Double(Double.NaN);

	public static Number process(String s) {
		Pattern pattern = Pattern.compile("^[-//+]?//d+(//.//d*)?|//.//d+$");
		//System.out.println(s.matches("^[-//+]?//d+(//.//d*)?|//.//d+$"));
		if (s.matches("^[-//+]?//d+(//.//d*)?|//.//d+$")) {
			try {
				double dd = Double.parseDouble(s);
				System.out.println("It's a double: " + dd);
				return new Double(dd);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				return NAN;
			}
		} else {
			try {
				int num = Integer.parseInt(s);
				System.out.println("It's a int: " + num);
				return new Integer(num);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				return NAN;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(process("-1213.21"));
	}
}
