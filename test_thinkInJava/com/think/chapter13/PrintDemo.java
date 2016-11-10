package com.think.chapter13;
/**
 * 格式化输出
 */
import java.io.PrintStream;
import java.util.Formatter;

public class PrintDemo {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		System.out.format("Row 1[%d %d]\n", x, y);
		PrintStream outAlias = System.err;
		Turtle t1 = new Turtle("tom", new Formatter(outAlias));
		t1.move(4, 3);
		System.out.println(String.format("Row [%d,%d]", x,y));
		Receipt receipt = new Receipt();
		receipt.printTitle();
		receipt.print("Jack's Magic Beans", 4, 4.25);
		receipt.print("Princess Peas", 3, 5.1);
		receipt.print("Thress Bears Porridge", 1, 14.29);
		receipt.printTotal();
		
	}
}

class Turtle {
	private String name;
	private Formatter f;

	public Turtle(String name, Formatter f) {
		this.f = f;
		this.name = name;
	}

	public void move(int x, int y) {
		f.format("%s move to (%d,%d)\n",name, x, y);
	}
}
class Receipt{
	private double total = 0;
	private Formatter f = new Formatter(System.out);
	public void printTitle(){
		f.format("%-15s %5s %10s\n", "Item","Qty","Price");
		f.format("%-15s %5s %10s\n", "----","---","----");
	}
	public void print(String name,int qty,double price){
		f.format("%-15.15s %5s %10.2f\n", name,qty,price);
		total+=price;
	}
	public void printTotal(){
		f.format("%-15s %5s %10.2f\n", "Tax","",total*0.5);
		f.format("%-15s %5s %10s\n", "","","-----");
		f.format("%-15s %5s %10.2f\n", "Total","",total*1.05);
	}
}
