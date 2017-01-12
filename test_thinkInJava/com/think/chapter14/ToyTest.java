package com.think.chapter14;

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name:" + cc.getName() + " is interface?[" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
            c = Class.forName("com.think.chapter14.FactoryToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Cant not find FactoryToy");
		}
		printInfo(c);
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Can not instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
		Toy toy = (Toy) obj;
		toy.say();
	}
}

interface HasBatteries {
};

interface Waterproof {
};

interface Shoots {
};

class Toy {
	{
		System.out.println("--------I am a toy");
	}
	//Toy() {}

	Toy(int i) {
	}
	public void say(){
		System.out.println("Success to construct a toy demo");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " toy toy toy";
	}
}

class FactoryToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FactoryToy() {
		super(1);
	}
}
