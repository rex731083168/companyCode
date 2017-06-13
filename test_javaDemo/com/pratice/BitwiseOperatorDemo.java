package com.pratice;

import org.junit.Test;

public class BitwiseOperatorDemo {
    public static void main(String[] args) {
    	String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
	}
    @Test
    public void test(){
    	String ss = "abcdefg";
    	System.out.println(ss.substring(1));
    	System.out.println(ss.charAt(0));
    	//System.out.println(reverse(ss));
    }
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
            System.out.println(originStr);
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
