package com.think.chapter13;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxString {
	public static void main(String[] args) {
		// System.out.println("sdfdsf".subSequence(1, 3));
		// System.out.println("-1234".matches("-?\\d+"));
		String[] strings = { "abcabcabcdefabc", "abc+", "(abc)+", "(abc){2,}" };
		for (String s : strings) {
			System.out.println("The string is:" + s);
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(strings[0]);
			while (matcher.find()) {
				System.out.println("Match \"" + matcher.group() + "\" at positions " + matcher.start() + "-"
						+ (matcher.end() - 1));
			}
		}
	}
}
