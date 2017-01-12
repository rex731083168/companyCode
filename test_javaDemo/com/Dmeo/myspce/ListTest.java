package com.Dmeo.myspce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListTest {
	public static void main(String[] args) {
		List<List<String>> listTest = new ArrayList<>();
		listTest.add(Arrays.asList("tom", "sam", "harry", "gaosu"));
		listTest.add(Arrays.asList("sfa", "sam", "wrsdf", "agg"));
		listTest.add(Arrays.asList("tom", "were", "gdga", "gagdgosu"));
		Map<String, List<Integer>> map = new HashMap<>();// 某个元素出现在大list集合的哪个位置()
		for (int i = 0; i < listTest.size(); i++) {
			Set<String> testSet = new HashSet<>();
			List<String> mainTest = listTest.get(i);
			if (i != listTest.size() - 1) {
				for (int j = i + 1; j < listTest.size(); j++) {
					List<String> judgetList = listTest.get(i);
				    judgetList.addAll(mainTest);
					testSet.addAll(judgetList);
					if (testSet.size() < mainTest.size() * 2) {
						System.out.println(i + "和" + j + "位置的list存在相同元素");
					}
				}
			}
		}
		// System.out.println(map);
	}
}
