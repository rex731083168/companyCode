package com.bruce.thread;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.NotImplementedException;

/**
 * 缓冲队列
 * 
 * @author bruce
 *
 * @param <T>
 */
public class DoubleBufferQueue<T> extends AbstractQueue<T> implements Queue<T> {
	private ReentrantLock readLock = new ReentrantLock();
	private ReentrantLock writeLock = new ReentrantLock();
	private LinkedList<T> readQueue = new LinkedList<T>();
	private LinkedList<T> writeQueue = new LinkedList<T>();

	public DoubleBufferQueue() {
		super();
	}

	/**
	 * 添加一个元素并返回true
	 */
	@Override
	public boolean offer(T e) {
		writeLock.lock();
		try {
			return writeQueue.offer(e);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * 移除并返问队列头部的元素
	 */
	@Override
	public T poll() {
		readLock.lock();
		try {
			if (readQueue.size() == 0) {
				swap();
			}

			return readQueue.poll();
		} finally {
			readLock.unlock();
		}
	}

	/**
	 * 返回队列头部的元素
	 */
	@Override
	public T peek() {
		readLock.lock();
		try {
			if (readQueue.size() == 0) {
				swap();
			}
			return readQueue.peek();
		} finally {
			readLock.unlock();
		}
	}

	/**
	 * 增加一个元索
	 */
	@Override
	public boolean add(T e) {
		writeLock.lock();
		try {
			return writeQueue.add(e);
		} finally {
			writeLock.unlock();
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		writeLock.lock();
		try {
			return writeQueue.addAll(c);
		} finally {
			writeLock.unlock();
		}
	}

	@Override
	public Iterator<T> iterator() {
		throw new NotImplementedException();
	}

	@Override
	public int size() {
		readLock.lock();
		writeLock.lock();
		try {
			return readQueue.size() + writeQueue.size();
		} finally {
			try {
				writeLock.unlock();
			} finally {
				readLock.unlock();
			}
		}
	}

	/**
	 * 读队列和写队列交换
	 */
	private void swap() {
		writeLock.lock();
		try {
			if (writeQueue.size() > 0) {
				LinkedList<T> tmp = readQueue;
				readQueue = writeQueue;
				writeQueue = tmp;
				tmp = null;
			}
		} finally {
			writeLock.unlock();
		}
	}
}
