package com.think.chapter13;
/**
 * toString方法打印对象地址，应使用super.toString。使用this或者this.toString会出现递归调用，
 */
import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
	public static void main(String[] args) {
        List<InfiniteRecursion> lists = new ArrayList<>();
        for(int i=0;i<10;i++){
        	lists.add(new InfiniteRecursion());
        }
        String s1 = "abc";
        String s2 = "ab"+"c";
        System.out.println(s1==s2.intern());
        System.out.println(lists);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
