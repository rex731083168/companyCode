package com.bruce.javaArithmetic;
/**
 * 打印数字
 * @author admin
 *
 */
public class PrintoutNumber {
    public static void main(String[] args) {
		printNumber(2324);
	}
    
    public static void printNumber(int n){
    	 if(n>=10){
    		 printNumber(n/10);
    	 }
    	 System.out.print(n%10+"");
    }
}
