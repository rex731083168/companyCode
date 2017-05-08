package com.bruce.javaArithmetic;

public class BinarySearchDemo {
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) {
		Integer[] arr = {5,8,12,34,56,78,99,131};
		int number = 131;
		int position = search(arr, number);
		if(position!=-1){
			System.out.println("在数组中找到该数:"+number+",在数组的第"+(position+1)+"个位置");
		}else {
			System.out.println("数组中没有该数");
		}
	}
    public static <AnyType extends Comparable<? super AnyType>> int search(AnyType[] arr,AnyType x){
    	int low = 0,high = arr.length-1;
    	while(low<=high){
    		int mid = (low+high)/2;
    		if(arr[mid].compareTo(x)<0){
    			low = mid+1;
    		}else if (arr[mid].compareTo(x)>0) {
				high = mid-1;
			}else {
				return mid;
			}
    	}
    	return NOT_FOUND;
    }
}
