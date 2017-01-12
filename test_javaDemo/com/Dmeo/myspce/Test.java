package com.Dmeo.myspce;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
     public static void main(String[] args) throws ParseException {
    	 List<List<Integer>> listTest = new ArrayList<List<Integer>>();//大的list
    	 Integer[] int1 = {1,3,4,5,7};
    	 Integer[] int2 = {2,3,6,5,7};
    	 Integer[] int3 = {5,9,14,15,17};
    	 List<Integer> list1 = Arrays.asList(int1);
    	 List<Integer> list2 = Arrays.asList(int2);
    	 List<Integer> list3 = Arrays.asList(int3);
    	 listTest.add(list1);
    	 listTest.add(list2);
    	 listTest.add(list3);
    	 Boolean flag = false;
    	 for(int i=0;i<listTest.size();i++){
    		 List<Integer> list = listTest.get(i);//得到第i个list集合
    		 int num = list.get(1);//确定第i个list第2个元素是否在其他的list集合中是否存在 ，这里是第二个元素
    		 List<Integer> position = isContains(listTest, num);//得到该元素在大list里面存在的位置
    		 if(position.size()>1){
    			 flag = true;
    			 System.out.println("是否存在相同的元素: "+ num+",出现在该list集合中的"+position+"位置");
    		 }
    	 }
       if(flag){
    	   System.out.println("集合中存在2个集合有相同的元素");
       }
	}
     //判断该元素在list集合中的哪个list中存在
     public static List<Integer> isContains(List<List<Integer>> lists,int num){
    	 List<Integer> position = new ArrayList<>();
    	 for(int i=0;i<lists.size();i++){
    		 List<Integer> numList = lists.get(i);
    		 if(numList.contains(num)){
    			 System.out.println("具有该元素的list位置: "+i);
    			position.add(i);
    		 }
    	 }
    	 return position;
     }
}
