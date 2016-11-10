package com.think.chapter13;

public class Immutable {
    public static String upcase(String s){
    	return s.toUpperCase();
    }
    public static void main(String[] args) {
		String qq = "sdffsd";
		System.out.println(upcase(qq));
	}
}
