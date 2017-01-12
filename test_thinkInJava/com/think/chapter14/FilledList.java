package com.think.chapter14;
/**
 * 泛型class实例
 */
import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {
	private Class<T> type;

	private FilledList(Class<T> type) {
		this.type = type;
	}

	public List<T> creater(int nElements) {
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());
				//System.out.println(type.newInstance());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return result;
	}

	public static void main(String[] args) {
		FilledList<CountedInteger> f1 = new FilledList<>(CountedInteger.class);
		System.out.println(f1.creater(12));
		CountedInteger cInteger = new CountedInteger();
		CountExtend ce = new CountExtend();
		Class c1 = cInteger.getClass();
		Class c2 = ce.getClass();
		Class d = c2.asSubclass(c1);
		System.out.println(d);
		
	}
}

class CountedInteger {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return ""+id;
	}
}
class CountExtend extends CountedInteger{
	
}
