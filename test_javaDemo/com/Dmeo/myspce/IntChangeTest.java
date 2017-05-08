package com.Dmeo.myspce;

public class IntChangeTest {
	static int a = 4;
	static int b = 5;
    public static void main(String[] args) {
    	new IntChangeTest().change(a,b);
    	System.out.println("a："+a+"************b:"+b);
    	//change(a1, b1);
	}
    public  void change(int a,int b){
    	this.a = 400;
    	this.b = 500;
    }
}
