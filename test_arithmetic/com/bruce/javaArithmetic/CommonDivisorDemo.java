package com.bruce.javaArithmetic;
/**
 * 求2个数的最大公约数
 * @author admin
 *
 */
public class CommonDivisorDemo {
	public static void main(String[] args) {
		System.out.println(gcd1(25, 5));
		System.out.println(gcd2(5,25));
	}
    private static int gcd1(int m,int n){
    	if(m<n){
    		int temp = m;
    		m=n;
    		n= temp;
    	}
    	if(n==0) return m;
    	int q = m%n;
    	return gcd1(n, q);
    }
    
    private static int gcd2(int m,int n){
    	if(m<n){
    		int temp = m;
    		m=n;
    		n= temp;
    	}
    	while(n!=0){
    		int tep = m%n;
    		m=n;
    		n=tep;
    	}
    	return m;
    }
}
