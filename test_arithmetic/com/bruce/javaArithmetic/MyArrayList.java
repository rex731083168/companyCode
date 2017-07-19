package com.bruce.javaArithmetic;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 简单实现ArrayList
 * @author admin
 *
 * @param <AnyType>
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPCITY = 10;
	private int theSize;
	private AnyType[] theItem;

	public MyArrayList() {
        clear();
	}

	/**
	 * 清除数据(默认创建大小为10的数组)
	 */
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPCITY);
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 从集合获取数据
	 * 
	 * @param idx
	 * @return
	 */
	public AnyType get(int idx) {
		if (idx < 0 || idx > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItem[idx];
	}
    /**
     * 更新某个位置的数据
     * @param idx
     * @param newVal
     * @return
     */
	public AnyType set(int idx, AnyType newVal) {
		if (idx < 0 || idx > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType old = theItem[idx];
		theItem[idx] = newVal;
		return old;
	}

	/**
	 * 向某个位置添加元素
	 * 
	 * @param idx
	 * @param newVal
	 */
	public void add(int idx, AnyType newVal) {
		if (theItem.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		for (int i = theSize; i > idx; i--) {
			theItem[i] = theItem[i - 1];
		}
		theItem[idx] = newVal;
		theSize++;
	}

	/**
	 * 尾部添加元素
	 * 
	 * @param newVal
	 * @return
	 */
	public boolean add(AnyType newVal) {
		add(size(), newVal);
		return true;
	}

	/**
	 * 容量扩充
	 */
	private void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		AnyType[] old = theItem;
		theItem = (AnyType[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			theItem[i] = old[i];
		}
	}

	/**
	 * 移除某个元素
	 * 
	 * @param idx
	 * @return
	 */
	public AnyType remove(int idx) {
		AnyType removeItem = theItem[idx];
		for (int i = idx; i < size() - 1; i++) {
			theItem[i] = theItem[i + 1];
		}
		theSize--;
		return removeItem;
	}
    /**
     * 返回迭代器
     */
	@Override
	public Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}
    /**
     * 内部类实现iterator
     * @author admin
     *
     */
	private class ArrayListIterator implements Iterator<AnyType> {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public AnyType next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return theItem[current++];
		}

		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(12);
		list.add(16);
		list.add(11);
		list.add(13);
		System.out.println(list.remove(1));
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			int arr = iterator.next();
		    System.out.print(arr+" ");
		}
		System.out.println();
		list.clear();
		System.out.println(list.size());
	}
}
