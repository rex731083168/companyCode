package com.String.util;

import java.util.Arrays;

public class StringTest {
	public static void main(String[] args) {
		char value[] = {'a','c','g','d','z'};
        char newValue[] = new char[value.length];
        System.arraycopy(value,0,newValue,0,Math.min(value.length,newValue.length));
        System.out.println(Arrays.toString(newValue));
        System.out.println("".isEmpty());
        System.out.println("168"!="");
	}
}
