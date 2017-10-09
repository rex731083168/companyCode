package com.bruce.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class MyLock {
	private AtomicBoolean lock = new AtomicBoolean(false);

	public boolean lock() {
		while (!lock.compareAndSet(false, true)) {
		}
		return false;
	}

	public void unlock() {
		lock.compareAndSet(true, false);
	}
}

class MyThread extends Thread {
	private Lock lock;

	public MyThread(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		lock.unlock();
	}
}

class ThreadTest {
	public static void main(String[] args) {
		//Lock myLock = new MyLock();
	}
}
