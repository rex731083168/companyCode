package com.pratice;

public class FornameDemo {
    public static void main(String[] args) {
		Cooklet cooklet = null;
		try {
			@SuppressWarnings("rawtypes")
			Class cookletClass  = Class.forName("com.pratice.DemoCooklet");
			Object cookletObject = cookletClass.newInstance();
			cooklet = (Cooklet) cookletObject;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		cooklet.work();
		cooklet.terminate();
	}
}

abstract class Cooklet{
	public void initialize(){}
	public void work(){}
	public void terminate(){}
}
class DemoCooklet extends Cooklet{
	public void work(){
		System.out.println("I am busy baking cookies");
	}
	public void terminate(){
		System.out.println("I am shuttting down my ovens now");
	}
}
