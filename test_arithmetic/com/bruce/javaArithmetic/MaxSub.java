package com.bruce.javaArithmetic;

import java.util.Arrays;

/**
 * 获取最大子序列和
 * @author admin
 *
 */
public class MaxSub {
    public static void main(String[] args) {
		int[] arr = {-1,3,43,-33,2,5,7,8,-1,45,7,-9-11,24};
		int[] arr2 = {4,-3,5,-2,-1,2,6,-2};
		System.out.println("数组的最大子序列和方法1："+getMaxSum1(arr));
		System.out.println("数组的最大子序列和方法2: "+getMaxSum2(arr));
		System.out.println("数组的最大子序列和方法3: "+getMaxSum3(arr));
		System.out.println("数组的最大子序列和方法4: "+getMaxSum4(arr,0,arr.length-1));
	}
    //方法1
	private static int getMaxSum1(int[] arr) {
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++) {
					thisSum += arr[k];
				}
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	//方法2，改进方法1
	private static int getMaxSum2(int[] arr){
		int maxSum = 0;
		for(int i=0;i<arr.length;i++){
			int thisSum = 0;
			for(int j=i;j<arr.length;j++){
				thisSum+=arr[j];
				if(thisSum>maxSum){
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	//方法3 
	private static int getMaxSum3(int[] arr){
		int maxSum = 0,thisSum=0;
		for(int i=0;i<arr.length;i++){
			thisSum+=arr[i];
			if(thisSum>maxSum){
				maxSum = thisSum;
			}else if(thisSum<0){
				thisSum =0;
			}
		}
		return maxSum;
	}
	//方法4
	private static int getMaxSum4(int[] arr,int left,int right){
		if(left==right){
			if(arr[left]>0){
				return arr[left]; 
			}else {
				return 0;
			}
		}
		int center = (left+right)/2;
		int maxLeftSum = getMaxSum4(arr, left, center);
		int maxRightSum = getMaxSum4(arr, center+1, right);
		int maxLeftBorderSum = 0,leftBorderSum=0;
		for(int i = center;i>=left;i--){
			leftBorderSum+=arr[i];
			if(leftBorderSum>maxLeftBorderSum){
				maxLeftBorderSum = leftBorderSum;
			}
		}
		int maxRightBorderSum = 0,rightBorderSum=0;
		for(int i = center+1;i<=right;i++){
			rightBorderSum+=arr[i];
			if(rightBorderSum>maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
			}
		}
		//System.out.println("left:"+left+",center:"+center+",right:"+right);
		//System.out.println("左："+maxLeftSum+"，右:"+maxRightSum+"中:"+(maxLeftBorderSum+maxRightBorderSum));
		return getMaxNumber(maxLeftSum, maxRightSum, maxLeftBorderSum+maxRightBorderSum);
	}
	private static int getMaxNumber(int a,int b,int c){
		int[] arr = {a,b,c};
		Arrays.sort(arr);
		return arr[2];
	}
}
