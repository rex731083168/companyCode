package com.bruce.javaArithmetic;

import java.math.BigDecimal;

public class TestMath {
    public static void main(String[] args) {
		BigDecimal powerMath = getPowerNumber(2, 5);
		System.out.println(Mod());
	}
    private static BigDecimal getPowerNumber(double n,double m){
    	double result = Math.pow(n, m);
    	return new BigDecimal(result);
    }
    
    public static int Mod(){
    	double result = Math.pow(2, 100);
    	System.out.println(result);
    	return (int) (result%5);
    }
}
