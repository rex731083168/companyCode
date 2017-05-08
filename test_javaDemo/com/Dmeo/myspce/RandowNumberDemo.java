package com.Dmeo.myspce;

import java.util.Random;

public class RandowNumberDemo {
    public static void main(String[] args) {
    	Random random = new Random();
		int a = random.nextInt(9);
		int b = random.nextInt(9);
		int c = random.nextInt(9);
		System.out.println(a+b+c);
	}
}
