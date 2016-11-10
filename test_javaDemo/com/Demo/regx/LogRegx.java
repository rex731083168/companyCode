package com.Demo.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRegx {
	public static void main(String[] args) {
		String regx = "^([\\d.]+)(\\S+)(\\S+)\\[([\\w:/]+\\s[+\\-]\\d{4})\\]\"(.+?)\"(\\d{3})(\\d+)\"([^\"]+)\"\"([^\"]+)\"";
		String ss = "123.45.67.89 - - [27/Oct/2000:09:27：09 -0400] \"GET /java/javaResources.html HTTP/1.0- 200 10450 wM〇zilla/4.6 [en] (Xll; U; OpenBSD 2.8 i386; Kav)\"";
		Matcher matcher = Pattern.compile(regx).matcher(ss);
		System.out.println(matcher.group(1));
	}	
}
