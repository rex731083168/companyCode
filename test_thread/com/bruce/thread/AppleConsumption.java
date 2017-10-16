package com.bruce.thread;

public class AppleConsumption implements Runnable {
	private Object lock = null;
	private String threadId = null;

	public AppleConsumption(int id, Object lock) {
		this.lock = lock;
		this.threadId = this.getClass().getName() + "-" + id;
	}

	@Override
	public void run() {
		boolean stop = false;
		Apple apple = new Apple();
		while (!stop) {
			try {
				Thread.sleep(1000);
				apple = ProcessCache.pollApple();
				if (apple != null) {
					System.out.println("吃掉一个苹果,编号为:" + apple.getId());
					stop = true;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (lock) {
			lock.notifyAll();
		}
	}
}
