package com.bruce.thread;

import java.util.Random;

public class AppleProducer implements Runnable {
	//全局锁
	private Object mainLock = null;

	public AppleProducer(Object mainLock) {
		this.mainLock = mainLock;
	}

	@Override
	public void run() {
		//(此处模拟交易过程)
        while(true) {
        	try {
        		//线程休眠2秒
				Thread.sleep(6000);
				//一次生产多个个苹果
				for(int i=0;i<10;i++) {
					Apple apple = new Apple(String.valueOf(new Random().nextInt(33)), String.valueOf(new Random().nextInt(55)));
					ProcessCache.addApple(apple);
				}
				//判断吃苹果线程的状态，如果是非运行状态，直接唤醒线程
				if(!ProcessCache.getProcessRunning()) {
	        		synchronized (mainLock) {
	        			ProcessCache.setProcessRunning(Boolean.TRUE);
	        			mainLock.notifyAll();
	        		}
	        	}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
}
