package com.bruce.javaArithmetic;

import java.util.Comparator;
/**
 * 查找最大数（泛型实现）
 * @author admin
 *
 */
public class FindMax {
	public static void main(String[] args) {
		String[] arr = {"asf","Dere","Bere","gere","zdf"};
		System.out.println(findmax(arr, new CaseInsensttiveCompare()));
		Rectangle r1 = new Rectangle(3.0, 3.0, 2.0);
		Rectangle r2 = new Rectangle(4.0, 5.0, 6.0);
		Rectangle[] arr2 = {r1,r2};
		System.out.println(findmax(arr2, new RectangelLengthCompare()));
	}
     public static <AnyType> AnyType findmax(AnyType[] arr,Comparator<? super AnyType> cmp){
    	 int maxIndex = 0;
    	 for(int i=0;i<arr.length;i++){
    		 if(cmp.compare(arr[i], arr[maxIndex])>0){
    			 maxIndex = i;
    		 }
    	 }
    	 return arr[maxIndex];
     }
}
class CaseInsensttiveCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}
 }
class RectangelLengthCompare implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle r1, Rectangle r2) {
		if(r1.getLength()>r2.getLength()){
			return 1;
		}else if (r1.getLength()<r2.getLength()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
/**
 * Rectangel class
 * @author admin
 *
 */
class Rectangle{
	private double side1;
	private double side2;
	private double side3;
	public Rectangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public double getLength(){
		return side1+side2+side3;
	}
	public double getWidth(){
		double s = (side1+side2+side3)/2;
		double width = s*(s-side1)*(s-side2)*(s-side3);
		return Math.sqrt(width);
	}
	@Override
	public String toString() {
		return "Rectangle :"+"【side1="+side1+",side2="+side2+",side3="+side3+"】";
	}
}
