package com.bruce.javaArithmetic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList简易实现
 * 
 * @author admin
 *
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	//维护2个节点
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;

	public MyLinkedList() {
		clear();
	}
    //清空
	public void clear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
	}

	public int size() {
		return theSize;
	}
    /**
     * 是否为空
     * @return
     */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * 新增数据
	 * @param x
	 * @return
	 */
	public boolean add(AnyType x){
		add(size(), x);
		return true;
	}
	/**
	 * 删除数据
	 * @param idx
	 * @return
	 */
	public AnyType remove(int idx){
		return remove(getNode(idx));
	}
	/**
	 * 获取某个位置的数据
	 * @param idx
	 * @return
	 */
	public AnyType get(int idx){
		return getNode(idx).data;
	}
	/**
	 * 更新节点的值
	 * @param idx
	 * @param newVal
	 * @return
	 */
	public AnyType set(int idx,AnyType newVal){
		Node<AnyType> p = getNode(idx);
		AnyType old = p.data;
		p.data = newVal;
		return old;
	}
	public void add(int idx,AnyType x){
		addBefore(getNode(idx), x);
	}
	/**
	 * 向某个元素前面添加节点
	 * @param p
	 * @param x
	 */
    private void addBefore(Node<AnyType> p,AnyType x){
    	Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
    	newNode.prev.next = newNode;
    	p.prev = newNode;
    	theSize++;
    	modCount++;
    }
    /**
     * 删除节点
     * @param p
     * @return
     */
    private AnyType remove(Node<AnyType> p){
    	p.next.prev = p.prev;
    	p.prev.next = p.next;
    	theSize--;
    	modCount++;
    	return p.data;
    }
    /**
     * 获取某个节点
     * @param idx
     * @return
     */
    private Node<AnyType> getNode(int idx){
    	Node<AnyType> p;
    	if(idx<0 || idx>size()){
    		throw new IndexOutOfBoundsException();
    	}
    	if(idx<size()/2){
    		p=beginMarker.next;
    		for(int i=0;i<idx;i++){
    			p = p.next;
    		}
    	}else{
    		p=endMarker;
    		for(int i=size();i>idx;i--){
    			p = p.prev;
    		}
    	}
    	return p;
    }
    /**
     * 获取迭代器
     */
	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	/**
	 * 内部类实现迭代器
	 * @author admin
	 *
	 */
	private class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
		@Override
		public boolean hasNext() {
			return current!=endMarker;
		}

		@Override
		public AnyType next() {
			if(modCount!=expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		public void remove(){
			if(modCount!=expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
	}
    /**
     * 节点内部类(用于构建双连表),每个节点都有链接前后节点的链
     * @author admin
     *
     * @param <AnyType>
     */
	private static class Node<AnyType> {
		public AnyType data; //数据
		public Node<AnyType> prev; //前置节点
		public Node<AnyType> next; //后置节点
		public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(16);
		list.add(23);
		list.add(22);
		list.add(1);
		list.add(11);
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.set(2, 777));
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			int arr = iterator.next();
			System.out.print(arr+" ");
		}
	}
}
