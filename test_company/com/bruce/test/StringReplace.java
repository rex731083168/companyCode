package com.bruce.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StringReplace {
   //@Test
   public void test1(){
	   String ss = "av;d;df;";
	   ss = ss.replaceAll(";{1,}$", "");
	   System.out.println(ss);
   }
   //@Test
   public void test2(){
	   String ss = "1;;";
	   String[] s1 = ss.split(";");
	   System.out.println("------"+s1.length);
   }
   public void test3(){
	   String st1 = "fsaasfd";
	    Map<String, String> ss = new HashMap<>();
   }
  
   public void test4(){
	   List<String> list = Arrays.asList("loo","qwqe");
	   list.forEach(System.out::println);
   }
   @Test
   public void test5(){
	   String[] name=  new String[]{"23e"};
   }
}
