package com.think.chapter14;
/**
 * .class弱引用
 */
import java.util.Random;

public class ClassInitialization {
    public static Random rand = new Random();
    public static void main(String[] args) throws ClassNotFoundException {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNoFinal);
		Class initable3 = Class.forName("com.think.chapter14.Initable3");
		System.out.println(Initable3.staticNonFinal);
	}
}
class Initable{
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static{
		System.out.println("Initializing Initable");
	}
}
class Initable2{
	static int staticNoFinal = 147;
	static{
		System.out.println("Initializing Initable2");
	}
}
class Initable3{
	static int staticNonFinal = 74;
	static{
		System.out.println("Initializing Initable3");
	}
}
