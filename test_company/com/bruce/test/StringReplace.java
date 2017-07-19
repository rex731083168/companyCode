package com.bruce.test;

import org.junit.Test;

public class StringReplace {
   //@Test
   public void test1(){
	   String ss = "av;d;df;";
	   ss = ss.replaceAll(";{1,}$", "");
	   System.out.println(ss);
   }
   @Test
   public void test2(){
	   String ss = "1;;";
	   String[] s1 = ss.split(";");
	   System.out.println("------"+s1.length);
   }
}
