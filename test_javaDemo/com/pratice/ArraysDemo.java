package com.pratice;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import org.junit.Test;

public class ArraysDemo {
    @Test
    public void testArrays(){
    	int[] arr = {1,24,13,5,17,8,10};
    	//bubbleSort(arr);
    	Arrays.parallelSort(arr);
    	Arrays.parallelPrefix(arr, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				return left*right;
			}
		});
    	System.out.println(Arrays.toString(arr));
    	System.out.println(Arrays.binarySearch(arr, 10));
    }
    public static void bubbleSort(int[] arr){
    	for(int i=0;i<arr.length-1;i++){
    		for(int j=0;j<arr.length-i-1;j++){
    			if(arr[j]>arr[j+1]){
    				int temp = arr[j];
    				arr[j] = arr[j+1];
    				arr[j+1] = temp;
    			}
    		}
    	}
    } 
}
