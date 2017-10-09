package com.String.util;

import org.apache.commons.lang.StringUtils;

public class StringUtilTest {
    public static void main(String[] args) {
		String ss = "  ";
		System.out.println(StringUtils.isEmpty(ss));
		System.out.println(StringUtils.isBlank(ss));
	}
}
