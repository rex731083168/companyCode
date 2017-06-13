package com.think.chapter13;
/**
 * 字符串转为大写
 * @author admin
 *
 */
public class Immutable {
    public static String upcase(String s){
    	return s.toUpperCase();
    }
    public static void main(String[] args) {
		String qq = "sdffsd";
		System.out.println(upcase(qq));
	}
}
