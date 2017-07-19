package com.bruce.javaArithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ListDemo {
	/**
	 * 去除集合的偶数项
	 * 
	 * @param lst
	 */
	private static void removeEvensVer(List<Integer> lst) {
		Iterator<Integer> itr = lst.iterator();
		while (itr.hasNext()) {
			if (itr.next() % 2 == 0) {
				itr.remove();
			}
		}
	}
	@Test
	public void testRemove(){
		List<Integer> list = new ArrayList<>();
		list.add(21);
		list.add(27);
		list.add(8);
		list.add(9);
		list.add(11);
		//list.add(12);
		removeEvensVer(list);
		System.out.println(list.toString());
	}
}
