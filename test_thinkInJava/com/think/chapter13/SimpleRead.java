package com.think.chapter13;

import java.io.BufferedReader;
import java.io.StringReader;

public class SimpleRead {
	public static BufferedReader input = new BufferedReader(new StringReader("Sir Rodin of Camlot\n22 1.161803"));
	public static void main(String[] args) {
		try {
			System.out.println("What is your name?");
			String name = input.readLine();
			System.out.println(name);
			System.out.println("How old are you? What is your favorite double");
			System.out.println("input<age><double>");
			String numbers = input.readLine();
			System.out.println(numbers);
			String[] numArray = numbers.split(" ");
			int age = Integer.parseInt(numArray[0]);
			Double favorite = Double.parseDouble(numArray[1]);
			System.out.printf("Hi %s \n",name);
			System.out.printf("In 5 years you will be %d.\n",age+5);
			System.out.printf("My favorite double is %f.",favorite/2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
