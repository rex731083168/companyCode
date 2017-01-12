package com.think.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PetsDdemo {
    public static void main(String[] args) throws ClassNotFoundException {
		Dog dog = new Dog();
		System.out.println(dog.getClass());
		System.out.println(Dog.class);
		System.out.println(Class.forName("com.think.chapter14.Dog"));
	}
}
class pets{
	String name;
	public pets() {
		// TODO Auto-generated constructor stub
	}
	public pets(String name) {
		this.name = name;
	}
}
class Dog extends pets{
	public Dog(String name) {
		super(name);
	}
	public Dog(){
		super();
	}
}
class Mutt extends Dog{
	public Mutt (String name){
		super(name);
	}
	public Mutt (){
		super();
	}
}
class Pug extends Dog{
	public Pug(String name){
		super(name);
	}
	public Pug (){
		super();
	}
}
class Cat extends pets{
	public Cat (String name){
		super(name);
	}
	public Cat(){
		super();
	}
}
class Manx extends Cat{
	public Manx(String name){
		super(name);
	}
	public Manx(){
		super();
	}
}
abstract class PetCreator{
	private Random rand = new Random(47);
	public abstract List<Class<? extends pets>> types();
	public pets randomPet(){
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public pets[] createArray(int size){
		pets[] result = new pets[size];
		for(int i=0;i<size;i++){
			result[i] = randomPet();
		}
		return result;
	}
	public ArrayList<pets> arrayList(int size){
		ArrayList<pets> result = new ArrayList<>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}

